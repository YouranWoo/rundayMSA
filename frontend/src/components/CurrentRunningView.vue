<template>

    <v-data-table
        :headers="headers"
        :items="currentRunning"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'CurrentRunningView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "runningStartTime", value: "runningStartTime" },
                { text: "runningStartLatitude", value: "runningStartLatitude" },
                { text: "runningStartLongitude", value: "runningStartLongitude" },
                { text: "runningEndTime", value: "runningEndTime" },
                { text: "runningEndLatitude", value: "runningEndLatitude" },
                { text: "runningEndLongitude", value: "runningEndLongitude" },
                { text: "runningTime", value: "runningTime" },
            ],
            currentRunning : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/currentRunnings'))

            temp.data._embedded.currentRunnings.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.currentRunning = temp.data._embedded.currentRunnings;
        },
        methods: {
        }
    }
</script>

