<template>
  <div class="“signup-page”">
    <h1>Sign Up Page</h1>
    <form @submit.prevent="“submitForm”">
      <label for="“user_id”">User ID:</label>
      <input type="“text”" id="“user_id”" v-model="“user_id”" />
      <br />
      <label for="“password”">Password:</label>
      <input type="“password”" id="“password”" v-model="“password”" />
      <br />
      <label for="“phoneNum”">Phone Number:</label>
      <input type="“text”" id="“phoneNum”" v-model="“phoneNum”" />
      <br />
      <label for="“name”">Name:</label>
      <input type="“text”" id="“name”" v-model="“name”" />
      <br />
      <label for="“clssName”">Class Name:</label>
      <input type="“text”" id="“clssName”" v-model="“clssName”" />
      <br />
      <button type="“submit”">Submit</button>
    </form>
  </div>
</template>
<script>
import axios from ‘axios’;
export default {
    name: ‘SignUpPage’,
    data() {
        return {
            user_id: ‘’,
            password: ‘’,
            phoneNum: ‘’,
            name: ‘’,
            clssName: ‘’,
        };
    },
    methods: {
        async submitForm() {
            if (this.id !== ‘’ && this.password !== ‘’) {
                const formData = {
                    userId: this.user_id,
                    password: this.password,
                    phoneNum: this.phoneNum,
                    name: this.name,
                    className: this.clssName,
                };
                try {
                    const response = await axios.post(‘http://localhost:8080/users/new’, formData);
                    const data = response.data;
                    console.log(data);
                    if (data > 0) {
                        this.$router.push(‘/’);
                        alert(‘회원 가입이 완료되었습니다.‘);
                    } else {
                        alert(‘회원 가입 형식과 맞지 않습니다.’);
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
.signup-page {
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
