<template>
  <!-- eslint-disable vue/no-v-html -->
  <v-app id="inspire">
      <router-view/>
  </v-app>

</template>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    /*margin-top: 60px;*/


  }

  html, body {
    height: 100%;
  }


  .buttonPosition {
    position: absolute;
    top: 50%;
    left: 50%;
    margin-top: 60px;
    margin-left: -100px;
  }

</style>
