<template>
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

          <v-form ref="form" v-model="valid" lazy-validation>
            <v-card-text>
              <v-text-field
                v-model="username"
                :rules="nameRules"
                :counter="5"
                label="Name"
                required
              ></v-text-field>
              <v-text-field
                v-model="password"
                :rules="emailRules"
                label="Passwort"
                required
              ></v-text-field>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                :disabled="!valid"
                @click="login"
              >
                Login
              </v-btn>
            </v-card-actions>
          </v-form>

        </v-card>
      </v-col>
    </v-row>

  </v-container>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'LoginZwei',

    data () {
      return {
        valid: true,
        username: '',
        password: '',
        nameRules: [
          v => !!v || 'Name is required',
        ],
        emailRules: [
          v => !!v || 'E-mail is required',
        ],
      }
    },

    methods: {
      async login () {
        if (this.$refs.form.validate()) {
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
