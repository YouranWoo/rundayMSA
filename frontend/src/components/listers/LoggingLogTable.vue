<template>
    <div>
        <v-data-table
                :headers="headers"
                :items="values"
                :items-per-page="5"
                class="elevation-1"
        ></v-data-table>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-fab-transition>
                            <v-btn
                                    color="primary"
                                    fab
                                    dark
                                    large
                                    style="position:absolute; bottom: 5%; right: 2%; z-index:99"
                                    @click="openDialog=true;"
                            >
                                <v-icon v-bind="attrs" v-on="on">mdi-plus</v-icon>
                            </v-btn>
                        </v-fab-transition>
                    </template>

                    <LoggingLog :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
                    <v-btn
                            style="postition:absolute; top:2%; right:2%"
                            @click="closeDialog()"
                            depressed 
                            icon 
                            absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
    const axios = require('axios').default;
    import LoggingLog from './../LoggingLog.vue';

    export default {
        name: 'LoggingLogManager',
        components: {
            LoggingLog,
        },
        props: {
            offline: Boolean,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            values: [],
            headers: 
                [
                    { text: "id", value: "id" },
                    { text: "userId", value: "userId" },
                    { text: "startTime", value: "startTime" },
                    { text: "startLatitude", value: "startLatitude" },
                    { text: "startLongitude", value: "startLongitude" },
                    { text: "endTime", value: "endTime" },
                    { text: "endLatitude", value: "endLatitude" },
                    { text: "endLongitude", value: "endLongitude" },
                    { text: "runningTime", value: "runningTime" },
                    { text: "userDiary", value: "userDiary" },
                    { text: "likesCount", value: "likesCount" },
                    { text: "runningPhoto", value: "runningPhoto" },
                ],
            log : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/logs'))
            temp.data._embedded.logs.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.logs;

            this.newValue = {
                'userId': '',
                'startTime': '2024-04-03',
                'startLatitude': 0,
                'startLongitude': 0,
                'endTime': '2024-04-03',
                'endLatitude': 0,
                'endLongitude': 0,
                'runningTime': 0,
                'userDiary': '',
                'likesCount': 0,
                'runningPhoto': {},
            }
        },
        methods: {
            closeDialog(){
                this.openDialog = false
            },
            append(value){
                this.tick = false
                this.newValue = {}
                this.values.push(value)
                
                this.$emit('input', this.values);

                this.$nextTick(function(){
                    this.tick=true
                })
            },
        }
    }
</script>

