<template>
  <div class="container">
    <b-button @click="modalShow = !modalShow, leeren()" variant="primary">Weiteren Teilnehmer hinzufügen</b-button>
    <b-modal v-model="modalShow" centered  title="Neuen Teilnehmer hinzufügen">
      <b-form-input
        class="form-group mx-sm-2 mb-2"
        id="input-1"
        v-model="teilnehmer.vorname"
        v-bind:class="{ 'is-invalid': teilnehmer.attemptSubmit && missingName}"
        placeholder="Vorname"
      ></b-form-input>
      <div class="mx-sm-3 mb-2">
        <div class="invalid-feedback">Bitte trage deinen Vornamen ein.</div>
      </div>

      <b-form-input
        class="form-group mx-sm-2 mb-2"
        id="input-2"
        v-model="teilnehmer.nachname"
        placeholder="Nachname"
        v-bind:class="{ 'is-invalid': teilnehmer.attemptSubmit && missingNachName}"
      ></b-form-input>

          <b-form-checkbox
            id="checkbox-1"
            v-model="status"
            name="checkbox-1"
            value="accepted"
          >
            Kind
          </b-form-checkbox>


        <b-form-input
          class="form-group mx-sm-2 mb-2"
          v-numericOnly
          name="alter"
          placeholder="Alter"
          v-model="teilnehmer.age"
          v-bind:class="{ 'is-invalid': teilnehmer.attemptSubmit && missingAge}"
          v-show="status">

        </b-form-input>

      <input
        type="radio" id="one"
        value="Freitag - Sonntag"
        v-model="teilnehmer.uebernachtungen"
        v-bind:class="{ 'is-invalid': teilnehmer.attemptSubmit && missingFrBisSo}">
      <label for="one">Freitag - Sonntag</label>
      <br>
      <input
        type="radio"
        id="two"
        value="Samstag - Sonntag"
        v-model="teilnehmer.uebernachtungen"
        v-bind:class="{ 'is-invalid': teilnehmer.attemptSubmit && missingSaBisSo}"
      >
      <label for="two">Samstag - Sonntag</label>
      <br>
      <span>Ausgewählt: {{ teilnehmer.uebernachtungen }}</span>


      <template v-slot:modal-footer="{ ok, cancel, hide }">
        <b-button size="sm" variant="secondary" @click="cancel()">
          Cancel
        </b-button>
        <b-button size="sm" variant="primary" @click="save()">
          OK
        </b-button>
      </template>
    </b-modal>
  </div>
</template>

<script>
  export default {
    name: 'ZusageTeilnehmerDialog',
    data () {
      return {
        modalShow: false,
        teilnehmer: {
          vorname: '',
          nachname: '',
          uebernachtungen: '',
          age: '',
          attemptSubmit: false
        },
        showAlter: false,
        status: false
      }
    },

    computed: {
      missingName: function () {
        return this.teilnehmer.vorname === '';
        },
      missingNachName: function () {
        return this.teilnehmer.nachname === '';
      },
      missingAge: function () {
        if(!this.status){
          return false
        }
        return this.teilnehmer.age === '';
      },
      missingFrBisSo: function () {
        return this.teilnehmer.uebernachtungen === ''
      },
      missingSaBisSo: function () {
        return this.teilnehmer.uebernachtungen === ''
      }
    },

    methods: {
      save (evt) {
        this.teilnehmer.attemptSubmit = true;
        if((this.missingName || this.missingNachName || this.missingAge || this.missingFrBisSo) ||
          (this.missingName || this.missingNachName || this.missingAge || this.missingSaBisSo)){
          // evt.preventDefault();
        }
        else {
        this.$emit('save', {
          vorname: this.teilnehmer.vorname,
          nachname: this.teilnehmer.nachname,
          uebernachtungen: this.teilnehmer.uebernachtungen,
          age: this.teilnehmer.age
        })
        this.modalShow = false
      }},
      leeren (){
        if(this.modalShow === true){
          this.teilnehmer.vorname = '';
          this.teilnehmer.nachname = '';
          this.teilnehmer.uebernachtungen = '';
          this.status = false;
          this.teilnehmer.age = '';
        }
      },

    },
    directives: {
      numericOnly: {
        bind(el, binding, vnode) {
          el.addEventListener('keydown', (e) => {
            if ([46, 8, 9, 27, 13, 110, 190].indexOf(e.keyCode) !== -1 ||
              // Allow: Ctrl+A
              (e.keyCode === 65 && e.ctrlKey === true) ||
              // Allow: Ctrl+C
              (e.keyCode === 67 && e.ctrlKey === true) ||
              // Allow: Ctrl+X
              (e.keyCode === 88 && e.ctrlKey === true) ||
              // Allow: home, end, left, right
              (e.keyCode >= 35 && e.keyCode <= 39)) {
              // let it happen, don't do anything
              return
            }
            // Ensure that it is a number and stop the keypress
            if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
              e.preventDefault()
            }
          })
        }

      }
    }
  }
</script>

<style scoped>

  .container button {
    display: block;
    margin: 0 auto;
  }

  .__BVID__29___BV_modal_footer_{
    background-color: #ffc0cb;
  }

</style>
