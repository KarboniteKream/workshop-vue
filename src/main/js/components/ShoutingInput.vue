<template>
  <div>
    <label class="label" :for="id">{{ label }}</label>
    <input :id="id"
           :value="inputValue"
           @input="startShouting($event.target.value)"
           :disabled="disabled" />
    <span class="hint">Hint: <slot></slot></span>
  </div>
</template>

<script>
export default {
  name: 'ShoutingInput',
  props: {
    label: String,
    value: String,
    disabled: {
      type: Boolean,
      default: false,
    },
  },
  data() {
    return {
      id: Math.random().toString().slice(2, 6),
      inputValue: this.value,
    };
  },
  methods: {
    startShouting(value) {
      this.$emit('input', value.toUpperCase());
    }
  },
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
