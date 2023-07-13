<template>
  <div>
    <h1>Edit Post</h1>
    <form @submit.prevent="submitForm">
      <div>
        <label for="title">Title:</label>
        <input type="text" id="title" v-model="post.title" />
      </div>
      <div>
        <label for="content">Content:</label>
        <textarea id="content" v-model="post.content"></textarea>
      </div>
      <button type="submit">Save</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      post: {
        title: "",
        content: "",
      },
    };
  },
  created() {
    // 서버로부터 게시글 데이터 가져오기
    // API 요청 등을 사용하여 데이터를 가져올 수 있음
    // 가져온 데이터를 this.post에 할당하여 폼에 초기화
    // 예: axios.get(`/api/posts/${this.$route.params.postId}`).then(response => this.post = response.data);
  },
  methods: {
    submitForm() {
      // 수정된 게시글 데이터를 서버로 전송하여 저장/업데이트
      axios
        .put(`/api/posts/${this.$route.params.postId}`, this.post)
        .then(() => {
          // 성공적으로 저장되었을 때의 동작
          console.log("Post updated successfully");
        })
        .catch((error) => {
          // 저장 실패 또는 에러 발생 시의 동작
          console.error("Error updating post:", error);
        });
    },
  },
};
</script>

<style>
/* 스타일링 옵션을 추가로 설정할 수 있음 */
</style>
