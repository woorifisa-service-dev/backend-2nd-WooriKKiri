package dev.woori.kkiri.boot.validator;

import dev.woori.kkiri.boot.dto.UserSaveDTO;
import dev.woori.kkiri.boot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class CheckErrorValidator extends AbstractValidator<UserSaveDTO> {

    private final UserRepository userRepository;

    @Override
    protected void doValidate(UserSaveDTO dto, Errors errors) {
        if(userRepository.existsByPhoneNum(dto.getPhoneNum())) {
            System.out.println("이미 있는 사용자입니다.");
        	errors.rejectValue("phoneNum", "이미 가입된 번호 입니다.");
        }else if(userRepository.existsByUserId(dto.getUserId())) {
        	errors.rejectValue("UserId", "이미 존재하는 ID 입니다.");
        }
    }
}