<template>

  <v-card class="mx-auto" max-width="344">

    <v-img class="myPic"></v-img>
    <v-card-title>Sonntag</v-card-title>
    <v-card-subtitle>Noch mal alles Revue passieren lassen...</v-card-subtitle>

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
          Beim Frühstück und einem starken Kaffee lässt sich der vergangene
          Tag bestens Revue passieren. Wer hat den Brautstrauß gefangen? Wer hat am längsten durchgehalten?
          Um 12 Uhr ist dann Checkout und langsam heißt es: Time to say Goodbye!
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>

</template>

<script>

    export default {
        name: "CardSunday",

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

  .myPic{
    background-image: url("../assets/sundown.jpg");
    height: 200px;
  }

</style>
