<template>
  <div class="perfect-centering">

      <div v-if="!submitted">

        <b-form @submit="saveTeilnehmer">

          <br>
          <div v-if="step === 1">
            <span class="material-icons xclass">looks_one</span>
            <b-form-group
              id="input-group-2"
              v-for="teilnehmer in teilnehmerListe" v-bind:key="teilnehmer.index">

              <div class="container">
                <b-col class="form-inline">
                  <b-form-input
                    class="form-group mx-sm-3 mb-2"
                    id="input-1"
                    v-model="teilnehmer.vorname"
                    v-bind:class="{ 'is-invalid': teilnehmer.attemptSubmitVN && teilnehmer.missingName}"
                    placeholder="Vorname"
                  ></b-form-input>

                  <b-form-input
                    class="form-group mx-sm-3 mb-2"
                    id="input-2"
                    v-model="teilnehmer.nachname"
                    v-bind:class="{ 'is-invalid': teilnehmer.attemptSubmitNN && teilnehmer.missingNachName}"
                    placeholder="Nachname"
                  ></b-form-input>
                  <div class="mx-sm-3 mb-2">
                    <div class="invalid-feedback">Bitte trage deinen Vornamen ein.</div>
                  </div>
                  <div class="mx-sm-3 mb-2">
                    <div class="invalid-feedback">Bitte trage deinen Nachnamen ein.</div>
                  </div>
                </b-col>
              </div>

            </b-form-group>
            <b-button v-on:click="add" variant="primary">Add</b-button>
            <b-button v-on:click="next" variant="primary">Weiter</b-button>
          </div>

          <div>
            <div v-if="step === 2" class="perfect-centering">
              <span class="material-icons xclass">looks_two</span>

              <div class="container">


                <b-form-select class="meineKlasse" v-model="uebernachtungen" :options="options"
                               style="width:auto"></b-form-select>

                <b-button v-on:click="prev" variant="primary">Previous</b-button>
                <b-button type="submit" variant="primary">Absenden</b-button>
              </div>
            </div>
          </div>
        </b-form>
      </div>

      <div v-else>
        <h4>Du wurdest erfolgreich hinzugefügt!</h4>
        <button class="btn btn-success" v-on:click="newTeilnehmer()">Weiteren Teilnehmer hinzufügen</button>
      </div>

<!--    </div>-->
  </div>
</template>


<script>

    import axios from 'axios'
    import {validationMixin} from 'vuelidate'
    import {required} from 'vuelidate/lib/validators'

    let index = 0;

    export default {
        name: "Zusage",


        data() {
            return {
                teilnehmerListe: [{

                        vorname: '',
                        nachname: '',
                    attemptSubmitVN: false,
                    attemptSubmitNN: false,
                    missingNachName: false,
                    missingName: false
                    }],
                uebernachtungen: null,
                options: [
                    {value: null, text: 'Bitte auswählen.'},
                    { value: 'Freitag auf Samstag', text: 'Übernachtung von Freitag auf Samstag.' },
                    { value: 'Samstag auf Sonntag', text: 'Übernachtung von Samstag auf Sonntag.' },
                    { value: 'beide', text: 'Beide Nächte.' },
                ],

                submitted: false,
                loading: true,
                reloadFormPage: false,
                countInvalid: 0,
                step: 1,
                vornameLeer: false,
                nachnameLeer: false
            }
        },
        methods: {
            saveTeilnehmer(evt) {
                    axios.post('/api/teilnehmer', {
                        teilnehmer: this.teilnehmerListe,
                        uebernachtungen: this.uebernachtungen
                    }).then((response) => {
                     console.log("erfolgreich")
                    })
                        .catch(e => {
                            console.log(e);
                        });
                    this.submitted = true;
                // }
            },

            add() {
                    this.teilnehmerListe.push({
                    //    id: this.teilnehmerListe.id,
                        index: index,
                        vorname: '',
                        nachname: '',
                        missingName: false,
                        missingNachName: false
                    });
                    index++;
            },

            newTeilnehmer() {
                this.submitted = false;
                for (var i = 0; i < this.teilnehmerListe.length; i++) {
                    this.teilnehmerListe[i].vorname = "";
                    this.teilnehmerListe[i].nachname = "";
                }
                this.teilnehmerListe.length = 1;
                this.reloadFormPage = true;
                this.missingName();
                this.missingNachName();
            },

            missingA() {
                console.log("Vorname");
                if(this.reloadFormPage === true) {
                    this.teilnehmerListe.attemptSubmitVN = false;
                    return false;
                }
                    for (var i = 0; i < this.teilnehmerListe.length; i++) {
                        if (this.teilnehmerListe[index].vorname === "") {
                            this.teilnehmerListe[index].attemptSubmitVN = true;
                            this.countInvalid++;
                           // evt.preventDefault();
                            this.teilnehmerListe[index].missingName = true
                        }else {
                            this.teilnehmerListe[index].attemptSubmitVN = false;
                            this.teilnehmerListe[index].missingName = false
                        }

                    }
                this.missingB();
            },
            missingB() {
                console.log("Nachname");
                if(this.reloadFormPage === true) {
                    this.teilnehmerListe.attemptSubmitNN = false;
                    return false;
                }
                    for (var i = 0; i < this.teilnehmerListe.length; i++) {
                        if (this.teilnehmerListe[index].nachname === "") {
                            this.teilnehmerListe[index].attemptSubmitNN = true;
                            this.countInvalid++;
                           // evt.preventDefault();
                            this.teilnehmerListe[index].missingNachName = true
                        } else {
                            this.teilnehmerListe[index].attemptSubmitNN = false;
                            this.teilnehmerListe[index].missingNachName = false
                        }
                    }
            },
            next() {
                this.countInvalid = 0;
                this.missingA();

                if(this.countInvalid > 0){
                    return false;
                }else {
                    this.step++
                }
            },
            prev() {
                this.step--;
            }

        },
    }

</script>

<style>

  .perfect-centering {
    position: center;
    margin-top: 15em;
    height: 700px;
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
