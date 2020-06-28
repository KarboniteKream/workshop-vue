<template>
  <div>
    <h1 v-bind:style="customStyle"
        v-bind:class="{ 'my-text': useCustomClass }">{{ eventTitle }}</h1>

    <div class="input-box">
      <label for="input">Enter a value:</label>
      <input id="input" v-model.trim="input" />
      <label for="times">Repeat this many times:</label>
      <input id="times" v-model.number="times" type="number" />
      <br />
      <span v-if="input">&uarr; This input is shouting: {{ repeatedInput.toUpperCase() }}</span>
    </div>

    <div class="input-box">
      <label for="password">Enter a password to encrypt it:</label>
      <input id="password" v-bind:value="password" v-on:change="superSafeEncrypt($event)" />

      <div v-if="password">
        <span v-if="!isEncrypted">&uarr; I can see the password 😲 It's <code>{{ password }}</code></span>
        <span v-else>&uarr; I can't see the password 😞 Maybe it's <code>hunter2</code>?</span>
      </div>
    </div>

    <div class="input-box">
      <div>
        <label for="question">Ask me a yes/no question!</label>
        <input id="question" v-model="question.value" v-on:keyup.enter="answerQuestion()" />
        <button v-on:click="answerQuestion()">Answer me!</button>
      </div>

      <span v-if="question.thinking">Thinking...</span>
      <div v-else>
        <img v-if="question.gif" :src="question.gif" alt="gif" />
        <span v-else>{{ question.answer }}</span>
      </div>
    </div>

    <div>
      <input id="feature-toggle" type="checkbox" v-model="advancedFeatures" />
      <label for="feature-toggle">Show advanced features</label>
    </div>

    <template v-if="advancedFeatures">
      <div class="advanced-features">
        <label for="color">Font color</label>
        <select id="color" v-model="colors.value">
          <option v-for="color of colors.list" v-bind:key="color.value"
                  v-bind:value="color.value">{{ color.name }}</option>
        </select>
      </div>

      <button v-on:click="useCustomClass = !useCustomClass">
        {{ useCustomClass ? 'Disable' : 'Enable' }} custom class
      </button>
    </template>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Basic',
  data() {
    return {
      event: 'Workshop',
      title: 'Vue',
      input: '',
      times: 1,
      password: '',
      question: {
        value: '',
        thinking: false,
        answer: '',
        gif: '',
      },
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
    superSafeEncrypt(event) {
      this.password = event.target.value.split('').map(() => '*').join('');
    },
    async answerQuestion() {
      if (!this.question.value.includes('?')) {
        this.question.answer = "That's not a question!";
        this.question.gif = '';
        return;
      }

      this.question.thinking = true;
      const response = await axios.get('https://yesno.wtf/api');
      this.question.answer = response.data.answer;
      this.question.gif = response.data.image;
      this.question.thinking = false;
    },
  },
  computed: {
    eventTitle() {
      return `Welcome to the ${this.title} ${this.event}!`;
    },
    repeatedInput() {
      return (this.input + ' ').repeat(this.times);
    },
    isEncrypted() {
      return this.password.split('').every(letter => letter === '*');
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
