<template>
  <div class="“main-page”">
    <h1>Welcome to the Main Page</h1>
    <button class="“main-button”" @click="“goToLoginPage”">Login</button>
    <button class="“main-button”" @click="“goToSignUpPage”">Sign Up</button>
  </div>
</template>
<script>
export default {
    methods: {
        goToLoginPage() {
            this.$router.push(‘/login’);
        },
        goToSignUpPage() {
            this.$router.push(‘/signup’);
        },
    },
};
</script>
<style scoped>
.main-page {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
}
h1 {
  font-size: 24px;
}
.main-button {
  background-color: #4caf50;
  color: #fff;
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  margin: 10px;
}
.main-button:hover {
  background-color: #45a049;
}
</style>
