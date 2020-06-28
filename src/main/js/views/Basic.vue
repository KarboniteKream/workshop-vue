<template>
  <div>
    <h1 v-bind:style="customStyle"
        v-bind:class="{ 'my-text': useCustomClass }">{{ eventTitle }}</h1>

    <div>
      <input id="feature-toggle" type="checkbox" v-model="advancedFeatures" />
      <label for="feature-toggle">Show advanced features</label>
    </div>

    <div v-if="advancedFeatures" class="advanced-features">
      <div>
        <label for="color">Font color</label>
        <select id="color" v-model="colors.value">
          <option v-for="color of colors.list" v-bind:key="color.value"
                  v-bind:value="color.value">{{ color.name }}</option>
        </select>
      </div>

      <button v-on:click="useCustomClass = !useCustomClass">
        {{ useCustomClass ? 'Disable' : 'Enable' }} custom class
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Basic',
  data() {
    return {
      event: 'Workshop',
      title: 'Vue',
      advancedFeatures: false,
      colors: {
        value: 'orange',
        list: [
          { value: 'orange', name: 'Orange' },
          { value: '#000', name: 'Black' },
          { value: '#ff00ff', name: 'Magenta' },
        ]
      },
      useCustomClass: false,
    };
  },
  methods: {
    // TODO
  },
  computed: {
    eventTitle() {
      return `Welcome to the ${this.title} ${this.event}!`;
    },
    customStyle() {
      return {
        color: this.colors.value,
        textTransform: 'uppercase',
      };
    },
  },
}
</script>

<style lang="scss" scoped>
label {
  margin-right: 10px;
}

.advanced-features {
  margin-top: 20px;
}

.my-text {
  text-decoration: underline;
  transition: 500ms;

  &:hover {
    transform: scale(1, -1);
  }
}
</style>
