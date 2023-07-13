<template>
  <div class="“login-page”">
    <h1>Login Page</h1>
    <form @submit.prevent="“submitForm”">
      <label for="“id”">ID:</label>
      <input type="“text”" id="“id”" v-model="“id”" />
      <br />
      <label for="“password”">Password:</label>
      <input type="“password”" id="“password”" v-model="“password”" />
      <br />
      <button type="“submit”">Login</button>
    </form>
  </div>
</template>
<script>
import axios from ‘axios’;
export default {
    name: ‘LoginPage’,
    data() {
        return {
            id: ‘’,
            password: ‘’,
        };
    },
    methods: {
        async submitForm() {
            if (this.id !== ‘’ && this.password !== ‘’) {
                const formData = {
                    userId: this.id,
                    password: this.password,
                };
                try {
                    const response = await axios.post(‘http://localhost:8080/users/login’, formData);
                    const data = response.data;
                    console.log(data);
                    if (data === true) {
                        this.loggedIn = true; // 로그인 성공 시 loggedIn 데이터를 true로 변경
                        this.$router.push(‘/’);
                    } else {
                        alert(‘Invalid ID or password’);
                        location.reload();
                    }
                } catch (error) {
                    console.error(error);
                }
            } else {
                alert(‘ID and password cannot be empty’);
            }
        },
    },
};
</script>
<style scoped>
.login-page {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f5f5f5;
}
h1 {
  font-size: 24px;
  text-align: center;
}
form {
  margin-top: 20px;
}
label {
  display: block;
  margin-bottom: 10px;
}
input[type="‘text’"],
input[type="‘password’"] {
  width: 100%;
  padding: 5px;
  font-size: 16px;
  border-radius: 3px;
  border: 1px solid #ccc;
  box-sizing: border-box;
  margin-bottom: 10px;
}
button[type="‘submit’"] {
  background-color: #4caf50;
  color: #fff;
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}
button[type="‘submit’"]:hover {
  background-color: #45a049;
}
</style>
