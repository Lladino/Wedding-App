<template>
<div>
  <div v-if="loading">

    <h1 class="loading">Loading...</h1>

  </div>


   <v-container>


  <h1>Teilnehmer</h1>


  <v-simple-table dark>
    <template v-slot:default>
      <thead>
      <tr>
        <th class="text-center">Vorname</th>
        <th class="text-center">Nachname</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="teilnehmer in teilnehmerListe">
        <td>{{teilnehmer.vorname}}</td>
        <td>{{teilnehmer.nachname}}</td>
      </tr>
      </tbody>
    </template>
  </v-simple-table>

</v-container>
</div>
</template>

<script>

    import axios from 'axios'

    export default {
        name: 'Teilnehmer',
        data () {
            return {
                teilnehmerListe: {
                    vorname: "",
                    nachname: "",
                },
                loading: true,
            }
        },

        created() {
            axios.get('/api/teilnehmer').then((response) => {
                this.teilnehmerListe = response.data;
            })
                .catch(error => {
                    this.error = "Failed to load todos"
                })
                .finally(() => this.loading = false)

        },

    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  h1, h2 {
    font-weight: normal;
  }
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
  }
</style>
