package dev.woori.kkiri.boot.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.woori.kkiri.boot.dto.LoginDTO;
import dev.woori.kkiri.boot.dto.UserSaveDTO;
import dev.woori.kkiri.boot.validator.CheckErrorValidator;
import dev.woori.kkiri.boot.model.User;
import dev.woori.kkiri.boot.security.SessionConstants;
import dev.woori.kkiri.boot.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
	private final UserService userService;
    private final CheckErrorValidator checkErrorValidator;
    @InitBinder
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(checkErrorValidator);
    }

	@PostMapping("/new")
    public String createUser(@Valid @RequestBody UserSaveDTO userSaveDTO, Errors errors, Model model) {
        // 검증 
        if (errors.hasErrors()) {
            // 회원가입 실패 시 입력 데이터 유지 
            model.addAttribute("dto", userSaveDTO);

            // 유효성 검사를 통과하지 못한 필드와 메세지 핸들링 
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }

            // 회원가입 페이지로 리턴 
            return null;
        }
       
		log.info("-- UserFormDTO, {}", userSaveDTO);
	    Long userId = userService.join(userSaveDTO);
        return null;
    }
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDTO loginDTO, Errors errors,HttpServletRequest request) {
		Optional<User> users  = userService.findByUserIdAndPassword(loginDTO.getUserId(), loginDTO.getPassword());
		if(users.isEmpty()) {
			System.out.println("일치하는 내용이 없습니다.");
			errors.reject("id나 비밀번호가 일치하지 않습니다.");
			return null;
			//return "/login/loginForm";
		}
		System.out.println("로그인을 시도합니다.");
		HttpSession session = request.getSession();                         // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
	    session.setAttribute(SessionConstants.LOGIN_USER, loginDTO);
		System.out.println(session);
		// return "redirect:"+ 본페이지;
		return null;
	}
	
	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {

	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();   // 세션 날림
	        System.out.println("로그아웃 했습니다.");
	    }
	    return null;
	    //return "redirect:/" + 홈페이지로 가기;
	}
}
