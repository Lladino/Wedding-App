<template>
  <!-- eslint-disable vue/no-v-html -->
  <div>
    <navbar></navbar>
    <v-main>
      <router-view/>
    </v-main>
    <v-footer fixed>
      <Footer></Footer>
    </v-footer>
  </div>

</template>

<script>

  import Navbar from './components/Navbar'
  import Navbar2 from './components/Navbar2'
  import Footer from './components/Footer'

  export default {
    name: 'Layout',
    components: {Footer, Navbar, Navbar2},
  }

</script>
