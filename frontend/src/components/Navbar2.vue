<template>
  <div class="sticky-top">
  <b-navbar toggleable="lg" type="dark" variant="primary">


    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav class="mx-auto">
        <b-nav-item>
          <router-link class="nav-link homeIcon" to="/home">
            <v-icon medium>home</v-icon>
          </router-link>
        </b-nav-item>
        <b-nav-item>
          <router-link class="nav-link" to="/feier">Feier</router-link>
        </b-nav-item>
        <b-nav-item>
          <router-link class="nav-link" to="/details">Details</router-link>
        </b-nav-item>
        <b-nav-item>
          <router-link class="nav-link" to="/details">Location</router-link>
        </b-nav-item>
        <b-nav-item>
          <router-link class="nav-link" to="/zusage3">Zusagen</router-link>
        </b-nav-item>
      </b-navbar-nav>
        <b-navbar-nav class="ml-auto">
        <b-nav-item class="right">
          <router-link class="nav-link">Logout</router-link>
        </b-nav-item>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
  </div>
</template>

<script>
    export default {
        name: "Navbar"
    }
</script>

<style scoped>




  .navbar-dark.navbar-expand-lg{
    background-color: white !important;
    box-shadow: 0 8px 15px -10px #333;
  }

  .navbar-dark .navbar-nav .nav-link{
    color: #943000;
    padding-left: 15px;
    padding-right: 15px;
    font-family: "Lucida Console", Courier, monospace;
  }

  .navbar-dark .navbar-nav .nav-link .homeIcon{
    padding: 4px !important;
  }
  .material-icons{
    color: #943000;
  }

  .navbar-dark .navbar-nav .nav-link a:hover{
    color: #ffc0cb;
  }

  .navbar-dark .navbar-nav .nav-link .homeIcon :hover{
    color: #ffc0cb;
  }

  .navbar-toggler{
    background-color: #943000;
  }

  .navbar-dark .navbar-nav .nav-link a:focus{
    color: #ffc0cb;
  }


</style>
