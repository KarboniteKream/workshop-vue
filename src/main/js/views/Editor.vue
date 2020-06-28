<template>
  <div>
    <h1>Editor</h1>

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
          <td>Item 1</td>
          <td>Value 1</td>
          <td>
            <button>&uarr;</button>
            <button>&darr;</button>
            <button>&times;</button>
          </td>
        </tr>
        <tr>
          <td>2</td>
          <td>Item 2</td>
          <td>Value 2</td>
          <td>
            <button>&uarr;</button>
            <button>&darr;</button>
            <button>&times;</button>
          </td>
        </tr>
        <tr>
          <td>3</td>
          <td>Item 3</td>
          <td>Value 3</td>
          <td>
            <button>&uarr;</button>
            <button>&darr;</button>
            <button>&times;</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'Editor',
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
</style>
