<template>
  <div>
    <h1>WELCOME TO THE VUE WORKSHOP!</h1>

    <div class="input-box">
      <label for="input">Enter a value:</label>
      <input id="input" />
      <label for="times">Repeat this many times:</label>
      <input id="times" value="1" type="number" />
      <br />
      <span>&uarr; This input is shouting: </span>
    </div>

    <div class="input-box">
      <label for="password">Enter a password to encrypt it:</label>
      <input id="password" />

      <div>
        <span>&uarr; I can see the password 😲 It's <code></code></span>
        <span>&uarr; I can't see the password 😞 Maybe it's <code>hunter2</code>?</span>
      </div>
    </div>

    <div class="input-box">
      <div>
        <label for="question">Ask me a yes/no question!</label>
        <input id="question" />
        <button>Answer me!</button>
        <Button>Focus question input</Button>
      </div>

      <span>Thinking...</span>
      <div>
        <img alt="gif" />
        <span></span>
      </div>
    </div>

    <div>
      <input id="feature-toggle" type="checkbox" />
      <label for="feature-toggle">Show advanced features</label>
    </div>

    <template>
      <div class="advanced-features">
        <label for="color">Font color</label>
        <select id="color">
          <option value="orange">Orange</option>
          <option value="#000">Black</option>
          <option value="#ff00ff">Magenta</option>
        </select>
      </div>

      <button>
        Enable custom class
      </button>
    </template>
  </div>
</template>

<script>
export default {
  name: 'Basic',
  data() {
    return {
      question: {
        value: '',
        thinking: false,
        answer: '',
        gif: '',
      },
      colors: {
        value: 'orange',
        list: [
          { value: 'orange', name: 'Orange' },
          { value: '#000', name: 'Black' },
          { value: '#ff00ff', name: 'Magenta' },
        ]
      },
    };
  },
}
</script>

<style lang="scss" scoped>
label {
  margin-right: 10px;
}

input:not([type="checkbox"]) {
  margin-right: 20px;
}

.input-box {
  margin: 20px 0;
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
