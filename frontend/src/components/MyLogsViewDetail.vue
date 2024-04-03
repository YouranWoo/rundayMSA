<template>

    <v-card outlined>
        <v-card-title>
            MyLogs # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Date label="StartTime" v-model="item.startTime" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="RunningTime" v-model="item.runningTime" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="UserDiary" v-model="item.userDiary" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="LikesCount" v-model="item.likesCount" :editMode="editMode" @change="change" />
            </div>
            <BigDecimal offline label="Photo" v-model="item.photo" :editMode="false" :key="false" @change="change" />
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MyLogsViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/myLogs/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

