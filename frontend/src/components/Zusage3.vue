<template>
  <div class="container">
    <div class="bottom-footer">
      <b-overlay :show="loading">
        <b-form>
          <b-form-group v-for="(teilnehmer, index) in teilnehmerListe" :key="index">
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
                <b-form-text class="form-group">
                  {{teilnehmer.age}}
                </b-form-text>
              </b-col>
              <b-col>
                <b-button @click="remove(index)"><b-icon-trash></b-icon-trash></b-button>
              </b-col>
            </b-row>
          </b-form-group>
          <ZusageTeilnehmerDialog @save="saveTeilnehmer"/>
          <div class="container">
          <b-button @click="complete()" variant="primary">abschließen</b-button>
          </div>
        </b-form>
      </b-overlay>
    </div>
  </div>
</template>


<script>
  import axios from 'axios'
  import ZusageTeilnehmerDialog from './ZusageTeilnehmerDialog'
  import { BIcon, BIconTrash} from 'bootstrap-vue'

  export default {
    name: 'Zusage3',
    components: {ZusageTeilnehmerDialog, BIcon, BIconTrash},
    data () {
      return {
        teilnehmerListe: [],
        loading: false
      }
    },
    methods: {
      saveTeilnehmer (teilnehmer) {
        this.teilnehmerListe.push(teilnehmer)
      },

      remove (index) {
        this.teilnehmerListe.splice(index, 1)
      },
      complete () {
        this.loading = true
        axios.post('/api/teilnehmer/add', this.teilnehmerListe).then(response => {
          this.loading = false
          alert("Danke")
          this.$router.push("/zusage3")
        })
      }

    },
  }

</script>

<style>

  .bottom-footer {
    margin-top: 10em;
    margin-bottom: 10em;
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

  .container button {
    display: block;
    margin: 0 auto;
  }

</style>
