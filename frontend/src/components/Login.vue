<template>
    <v-main>
      <v-container
        class="fill-height"
        fluid
      >
        <v-row
          align="center"
          justify="center"
        >
          <v-col
            cols="12"
            sm="8"
            md="4"
          >
            <v-card class="elevation-12">
              <v-toolbar
                color="primary"
                flat
              >
                <v-toolbar-title>Login form</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <v-form>
                  <v-text-field
                    label="Login"
                    name="login"
                    prepend-icon="mdi-account"
                    type="text"
                    v-model="username"
                  ></v-text-field>

                  <v-text-field
                    id="password"
                    label="Password"
                    name="password"
                    prepend-icon="mdi-lock"
                    type="password"
                    v-model="password"
                  ></v-text-field>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn @click="login" color="primary">Login</v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
</template>

<script>
  import axios from 'axios'

  export default {
    data () {
      return {
        username: '',
        password: ''
      }
    },
    methods: {
      async login () {
        return axios({
          method: 'POST',
          url: '/auth/login',
          baseURL: '/',
          params: {
            username: this.username,
            password: this.password,
          }
        }).then(() => {
          const redirectRoute = this.$route.query.redirectRoute && this.$route.query.redirectRoute.toString()
          return this.$router.push(redirectRoute || '/')
        }).catch()
      }
    }
  }

</script>

<style>


  .v-toolbar__content{
    background-color: #ffc0cb;
    color: #943000;
    font-family: "Lucida Console", Courier, monospace !important;
  }

  .v-application .primary{
    background-color: #ffc0cb !important;
    color: #943000 !important;
    font-family: "Lucida Console", Courier, monospace !important;;
  }


</style>
