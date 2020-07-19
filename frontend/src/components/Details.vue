<template>
  <div>
  <div class="bg2">
    <p></p>
  </div>
  <p></p>
    <br>
    <br>
    <div class="container">
      <b-card bg-variant="white" text-variant="black" title="Alles zu der Anreise">
        <b-card-text>
          Wie bekomme ich eine Unterkunft?
        </b-card-text>
        <b-button v-b-toggle.accordion-1 variant="primary">
      <span class="material-icons">add
      </span>
        </b-button>
        <b-collapse id="accordion-1">
          <b-card-body>
            <b-card-text>{{ text }}</b-card-text>
          </b-card-body>
        </b-collapse>
      </b-card>
    </div>
    <br>
    <br>
    <div class="container">
      <b-card bg-variant="white" text-variant="black" title="Gibt es einen Dress Code?">
        <b-card-text>
          Wie bekomme ich eine Unterkunft?
        </b-card-text>
        <b-button v-b-toggle.accordion-2 variant="primary">
      <span class="material-icons">add
      </span>
        </b-button>
        <b-collapse id="accordion-2">
          <b-card-body>
            <b-card-text>{{ text2 }}</b-card-text>
          </b-card-body>
        </b-collapse>
      </b-card>
    </div>
    <br>
    <br>
    <div class="container">
      <b-card bg-variant="white" text-variant="black" title="Wird am Freitag schon hart gefeiert?">
        <b-card-text>
          Wie bekomme ich eine Unterkunft?
        </b-card-text>
        <b-button v-b-toggle.accordion-3 variant="primary">
      <span class="material-icons">add
      </span>
        </b-button>
        <b-collapse id="accordion-3">
          <b-card-body>
            <b-card-text>{{ text3 }}</b-card-text>
          </b-card-body>
        </b-collapse>
      </b-card>
    </div>
    <br>
    <br>
    <br>
    <br>
  </div>
</template>

<script>
    export default {
        name: "Details",
        data() {
            return {
                text: `
          Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
          richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor
          brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
          tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
          assumenda shoreditch et.
        `,
                text2: 'Anim pariatur cliche reprehenderit ' +
                    'Anim pariatur cliche reprehenderit' +
                    'Anim pariatur cliche reprehenderit',
                text3: 'Anim pariatur cliche reprehenderit ' +
                    'Anim pariatur cliche reprehenderit' +
                    'Anim pariatur cliche reprehenderit'
            }
        }
    }
</script>

<style scoped>

  .bg2 {
    /* The image used */
    background-image: url("../assets/wedding-rings.jpg");

    /* Full height */
    height: 400px;
    margin-top: 100px;

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    background-attachment: fixed;
    /*background-size:  cover;*/
  }

  .jumbotron-fluid{
    background-color: rgba(231, 231, 255, 0.76);
  }

  .jumbotron-fluid h2{
   color: rgba(0, 0, 0, 0.76);
  }

  .jumbotron-fluid p{
    color: rgba(0, 0, 0, 0.76);
  }

  .card-body{
    padding: 0.01rem;
    margin-bottom: 1.5rem;
    text-align: center;
}
  .card-title {
    margin-top: 1.5rem;
  }

  .card-text {
    margin-top: 1.5rem;
  }
  .card {
    border-radius: 2.75rem;
    border-color: #ffc0cb;
  }


</style>
