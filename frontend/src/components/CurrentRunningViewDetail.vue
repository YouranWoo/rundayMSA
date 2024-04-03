<template>

    <v-card outlined>
        <v-card-title>
            CurrentRunning # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Date label="RunningStartTime" v-model="item.runningStartTime" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="RunningStartLatitude" v-model="item.runningStartLatitude" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="RunningStartLongitude" v-model="item.runningStartLongitude" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="RunningEndTime" v-model="item.runningEndTime" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="RunningEndLatitude" v-model="item.runningEndLatitude" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="RunningEndLongitude" v-model="item.runningEndLongitude" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="RunningTime" v-model="item.runningTime" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'CurrentRunningViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/currentRunnings/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

