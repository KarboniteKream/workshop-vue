<template>
  <div>
    <label class="label" :for="id">{{ label }}</label>
    <input :id="id"
           :value="value"
           @input="startShouting($event.target.value)"
           :disabled="disabled" />
    <span class="hint">Hint: <slot></slot></span>
  </div>
</template>

<script>
export default {
  name: 'ShoutingInput',
  model: {
    prop: 'whisper',
    event: 'shout',
  },
  props: {
    label: String,
    whisper: String,
    disabled: {
      type: Boolean,
      default: false,
    },
  },
  data() {
    return {
      id: '_' + Math.random().toString(36).slice(2, 10),
    };
  },
  methods: {
    startShouting(value) {
      this.$emit('shout', value.toUpperCase());
    }
  },
  computed: {
    value() {
      return this.whisper;
    }
  }
}
</script>

<style lang="scss" scoped>
.label {
  color: grey;
  margin-right: 10px;
}

.hint {
  margin-left: 10px;
}
</style>
