<template>
  <div>
    <h1>Editor<span v-if="formId"> (Form ID: {{ formId }})</span></h1>

    <div class="input-box">
      <shouting-input label="ID" v-model="formId">
        <strong>This is the form ID!</strong>
      </shouting-input>
    </div>

    <span>Items:</span>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Value</th>
          <th>Action</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="(item, index) of items" :key="item.id">
          <td>{{ item.id }}</td>
          <td><input v-model="item.name" /></td>
          <td><input v-model="item.value" /></td>
          <td>
            <button v-if="index > 0" @click="switchItems(index, index - 1)">&uarr;</button>
            <button v-if="index < items.length - 1" @click="switchItems(index, index + 1)">&darr;</button>
            <button @click="items.splice(index, 1)">&times;</button>
          </td>
        </tr>
      </tbody>
    </table>

    <button @click="addItem()">+ New item</button>
    <br />
    <button @click="items = []">Clear!</button>
    <pre>{{ items }}</pre>
  </div>
</template>

<script>
import ShoutingInput from '../components/ShoutingInput';

export default {
  name: 'Editor',
  components: {
    ShoutingInput,
  },
  data() {
    return {
      formId: '',
      items: [
        {
          id: 1,
          name: 'Item 1',
          value: 'Value 1',
        },
        {
          id: 2,
          name: 'Item 2',
          value: 'Value 2',
        },
        {
          id: 3,
          name: 'Item 3',
          value: 'Value 3',
        },
      ],
    };
  },
  methods: {
    switchItems(idx1, idx2) {
      const temp = this.items[idx1];
      this.$set(this.items, idx1, this.items[idx2]);
      this.$set(this.items, idx2, temp);
    },
    addItem() {
      const id = this.items.length + 1;

      this.items.push({
        id,
        name: `Item ${id}`,
        value: `Value ${id}`,
      });
    }
  },
}
</script>

<style lang="scss" scoped>
td {
  padding: 10px;
}

button {
  margin: 5px;
}

pre {
  font-family: "Courier New", monospace;
}
</style>
