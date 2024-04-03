<template>

    <v-data-table
        :headers="headers"
        :items="totalRank"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'TotalRankView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userId", value: "userId" },
                { text: "totalRunningTime", value: "totalRunningTime" },
                { text: "rank", value: "rank" },
            ],
            totalRank : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/totalRanks'))

            temp.data._embedded.totalRanks.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.totalRank = temp.data._embedded.totalRanks;
        },
        methods: {
        }
    }
</script>

