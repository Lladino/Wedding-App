<template>

  <v-card class="mx-auto" max-width="344">
    <v-img src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg" height="200px"></v-img>
    <v-card-title>Freitag</v-card-title>
    <v-card-subtitle>Ankommen und reinstarten...</v-card-subtitle>

    <v-card-actions>
<!--      <v-btn text>Share</v-btn>-->
<!--      <v-btn color="purple" text>Explore</v-btn>-->
      <v-spacer></v-spacer>
      <v-btn icon @click="showFriday = !showFriday">
        <v-icon>{{ showFriday ? 'arrow_upward' : 'arrow_downward' }}</v-icon>
      </v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="showFriday">
        <v-divider></v-divider>
        <v-card-text>
          Individuelle Anreise ab nachmittags. Weitere Information zu der Anfahrt findet ihr hier.
          Bis ca. <strong>22 Uhr</strong> können wir bei leckerem Essen und Getränken in das Wochenende starten.
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>

</template>

<script>
    export default {
        name: "CardFriday",

        data() {
            return {

                showFriday: false,

            }
        }
    }
</script>

<style scoped>

  .myRow{
    position: relative;
    /*left: 12em;*/
    top: 12em;
  }
</style>
