<template>

    <v-card outlined>
        <v-card-title>
            TotalRank # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="TotalRunningTime" v-model="item.totalRunningTime" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Rank" v-model="item.rank" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'TotalRankViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/totalRanks/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

