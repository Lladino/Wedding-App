<template>

  <v-card class="mx-auto" max-width="344">
    <v-img src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg" height="200px"></v-img>
    <v-card-title>Samstag</v-card-title>
    <v-card-subtitle>Wir freuen uns mit euch zu feiern - der große Tag</v-card-subtitle>

    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn icon @click="showSaturday = !showSaturday">
        <v-icon>{{ showSaturday ? 'arrow_upward' : 'arrow_downward' }}</v-icon>
      </v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="showSaturday">
        <v-divider></v-divider>
        <v-card-text>
          Heute starten wir den Tag mit einem leckeren Frühstück.
          Jetzt habt ihr noch etwas Zeit, um Erkundstouren über das Gut zu unternehmen oder einen kleinen Plausch mit den neuen
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>

</template>

<script>

    export default {
        name: "CardSaturday",

        data() {
            return {
                showSaturday: false
            }
        }
    }

</script>

<style scoped>

  .myRow{
    position: relative;
    top: 12em;
  }
</style>
