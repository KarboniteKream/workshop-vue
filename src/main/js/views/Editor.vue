<template>
  <div>
    <h1>Editor</h1>

    <div class="input-box">
      <shouting-input>
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
        <tr>
          <td>1</td>
          <td><input value="Item 1" /></td>
          <td><input value="Value 1" /></td>
          <td>
            <button>&uarr;</button>
            <button>&darr;</button>
            <button>&times;</button>
          </td>
        </tr>
        <tr>
          <td>2</td>
          <td><input value="Item 2" /></td>
          <td><input value="Value 2" /></td>
          <td>
            <button>&uarr;</button>
            <button>&darr;</button>
            <button>&times;</button>
          </td>
        </tr>
        <tr>
          <td>3</td>
          <td><input value="Item 3" /></td>
          <td><input value="Value 3" /></td>
          <td>
            <button>&uarr;</button>
            <button>&darr;</button>
            <button>&times;</button>
          </td>
        </tr>
      </tbody>
    </table>

    <div>
      <button>+ New item</button>
      <br />
      <button>Clear!</button>
    </div>

    <div class="input-box">
      <label>Devices:</label>
      <input id="ANDROID" type="checkbox" value="ANDROID" />
      <label for="ANDROID">ANDROID</label>
      <input id="IOS" type="checkbox" value="IOS" />
      <label for="IOS">IOS</label>
    </div>
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
      devices: {
        value: [],
        list: [
          'ANDROID',
          'IOS',
        ],
      },
    };
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
