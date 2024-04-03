<template>

    <v-data-table
        :headers="headers"
        :items="myLogs"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MyLogsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "startTime", value: "startTime" },
                { text: "runningTime", value: "runningTime" },
                { text: "userDiary", value: "userDiary" },
                { text: "likesCount", value: "likesCount" },
                { text: "photo", value: "photo" },
            ],
            myLogs : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/myLogs'))

            temp.data._embedded.myLogs.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.myLogs = temp.data._embedded.myLogs;
        },
        methods: {
        }
    }
</script>

