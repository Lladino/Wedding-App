<template>
  <div>
    <div class="bg">
      <div class="container">
        <h1><span>Willkommen zu unserer Hochzeitsseite</span></h1>
      </div>
    </div>
  </div>
</template>

<script>

    export default {
        name: "Home",

        data() {
            return {
            }
        }

    }
</script>

<style>

  .perfect-centering {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }

  .bg {
    /* The image used */
    background-image: url("../assets/wedding-rings.jpg");

    /* Full height */
    height: 800px;

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
  }

  h3{
    color: #a2a35a;
    background-color: #f5f69f;
  }

  h1 {
    text-align: center;
    position: relative;
    margin-top: 550px;
    color: #943000;
    font-family: Courier
  }
  h1 span {
    background-color: #ffc0cb;
  }

</style>
