
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import RunningRunningManager from "./components/listers/RunningRunningCards"
import RunningRunningDetail from "./components/listers/RunningRunningDetail"

import RankRankingManager from "./components/listers/RankRankingCards"
import RankRankingDetail from "./components/listers/RankRankingDetail"

import FriendRelationFriendsManager from "./components/listers/FriendRelationFriendsCards"
import FriendRelationFriendsDetail from "./components/listers/FriendRelationFriendsDetail"
import FriendRelationLikesManager from "./components/listers/FriendRelationLikesCards"
import FriendRelationLikesDetail from "./components/listers/FriendRelationLikesDetail"

import LoggingLogManager from "./components/listers/LoggingLogCards"
import LoggingLogDetail from "./components/listers/LoggingLogDetail"

import NotificationMessageManager from "./components/listers/NotificationMessageCards"
import NotificationMessageDetail from "./components/listers/NotificationMessageDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/runnings/runnings',
                name: 'RunningRunningManager',
                component: RunningRunningManager
            },
            {
                path: '/runnings/runnings/:id',
                name: 'RunningRunningDetail',
                component: RunningRunningDetail
            },

            {
                path: '/ranks/rankings',
                name: 'RankRankingManager',
                component: RankRankingManager
            },
            {
                path: '/ranks/rankings/:id',
                name: 'RankRankingDetail',
                component: RankRankingDetail
            },

            {
                path: '/friendRelations/friends',
                name: 'FriendRelationFriendsManager',
                component: FriendRelationFriendsManager
            },
            {
                path: '/friendRelations/friends/:id',
                name: 'FriendRelationFriendsDetail',
                component: FriendRelationFriendsDetail
            },
            {
                path: '/friendRelations/likes',
                name: 'FriendRelationLikesManager',
                component: FriendRelationLikesManager
            },
            {
                path: '/friendRelations/likes/:id',
                name: 'FriendRelationLikesDetail',
                component: FriendRelationLikesDetail
            },

            {
                path: '/loggings/logs',
                name: 'LoggingLogManager',
                component: LoggingLogManager
            },
            {
                path: '/loggings/logs/:id',
                name: 'LoggingLogDetail',
                component: LoggingLogDetail
            },

            {
                path: '/notifications/messages',
                name: 'NotificationMessageManager',
                component: NotificationMessageManager
            },
            {
                path: '/notifications/messages/:id',
                name: 'NotificationMessageDetail',
                component: NotificationMessageDetail
            },




    ]
})
