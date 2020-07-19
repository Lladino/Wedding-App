<template>
  <v-container>
    <header-feier></header-feier>
    <v-row class="myRow">
      <v-col cols="12" md="4">
        <card-friday></card-friday>
      </v-col>
      <v-col cols="12" md="4">
        <card-saturday></card-saturday>
      </v-col>
      <v-col cols="12" md="4">
        <card-sunday></card-sunday>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
    import CardFriday from "./CardFriday";
    import CardSaturday from "./CardSaturday";
    import CardSunday from "./CardSunday";
    import HeaderFeier from "./HeaderFeier";
    export default {
        name: "Feier",
        components: {CardSaturday, CardFriday, CardSunday, HeaderFeier},
        data() {
            return {

            }
        }
    }
</script>

<style scoped>

  .myRow{
    position: center;
    /*margin-left: 5em;*/
    margin-top: 10em;
    margin-bottom: 10em;
    /*height: 1000px;*/
  }

  .bg-neu {


    display: flex;
    justify-content: center;

  }

</style>
