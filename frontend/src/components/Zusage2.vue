<template>
  <div class="container">
    <div class="bottom-footer">
    <b-overlay :show="loading">
      <b-form>
        <b-form-group v-for="(teilnehmer, index) in teilnehmerListe" :key="teilnehmer.id">
          <b-row>
          <b-col>
            <b-form-text class="form-group">
              {{teilnehmer.vorname}}
            </b-form-text>
          </b-col>
          <b-col>
            <b-form-text class="form-group">
              {{teilnehmer.nachname}}
            </b-form-text>
          </b-col>
            <b-col>
            <b-form-text class="form-group">
              {{teilnehmer.uebernachtungen}}
            </b-form-text>
          </b-col>
          <b-col>
            <b-button @click="remove(index, teilnehmer.id)" variant="primary">DELETE ICON</b-button>
          </b-col>
          </b-row>
        </b-form-group>
        <ZusageTeilnehmerDialog @save="saveTeilnehmer"/>
      </b-form>
    </b-overlay>
  </div>
  </div>
</template>


<script>
  import axios from 'axios'
  import ZusageTeilnehmerDialog from './ZusageTeilnehmerDialog'

  export default {
    name: 'Zusage2',
    components: {ZusageTeilnehmerDialog},
    data () {
      return {
        teilnehmerListe: [],
        loading: true
      }
    },
    methods: {
      saveTeilnehmer (teilnehmer) {
        this.loading = true
        axios.post('/api/teilnehmer/save', teilnehmer).then(response => {
          this.teilnehmerListe.push(response.data)
          this.loading = false
        })
      },

      remove (index, id) {
        this.loading = true
        axios.post('/api/teilnehmer/delete', {id: id})
          .then(() => {
            this.teilnehmerListe.splice(index, 1)
            this.loading = false
          })
      },

    },
    beforeMount () {
      axios.get('/api/teilnehmer/list').then(response => {
        this.teilnehmerListe = response.data
        this.loading = false
      })
    }
  }

</script>

<style>

  .bottom-footer{
    height: 800px;
  }

  .btn-circle {
    width: 30px;
    height: 30px;
    text-align: center;
    padding: 6px 0;
    font-size: 12px;
    line-height: 1.428571429;
    border-radius: 15px;
    cursor: default;
  }

  .material-icons.xclass {
    color: #943000;
    font-size: 36px;

  }

  .btn.btn-primary {
    color: #ffffff;
    background-color: #943000;
    border-color: #943000;
    font-family: "Lucida Console", Courier, monospace;
  }

  .btn.btn-primary.active {
    color: #ffffff;
    background-color: pink;
    border-color: pink;
  }

  .btn.btn-primary:hover {
    color: #ffffff;
    background-color: pink;
    border-color: pink;
  }

</style>
