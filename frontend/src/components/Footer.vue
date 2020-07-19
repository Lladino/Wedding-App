<template>
  <footer>
    <div class="footer-special">
    <div class="container">
      <p class="text-p"> © {{ new Date().getFullYear() }} - All rights reserved.</p>
    </div>
    </div>
  </footer>
</template>

<script>
    export default {
        name: "Footer"
    }
</script>

<style>


  .footer-special {
    background-color: #f5f5f5;
    /*background-color: #edf55c;*/
    /*bottom: -100px;*/
    height: 60px;
    margin-top: auto;
    flex-shrink: 0;
    width: 100%;
  }

</style>
