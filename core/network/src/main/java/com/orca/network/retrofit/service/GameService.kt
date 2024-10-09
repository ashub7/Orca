package com.orca.network.retrofit.service

import com.orca.network.model.AchievementResponse
import com.orca.network.model.GameDetailResponse
import com.orca.network.model.GamePersonResponse
import com.orca.network.model.GameResponse
import com.orca.network.model.base.PagedResponse
import com.orca.network.model.RecentPostResponse
import com.orca.network.model.ScreenShotResponse
import com.orca.network.model.TwitchStreamResponse
import com.orca.network.model.YoutubeChannelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface GameService {
        /**
         * Get a list of games.
         * @property page integer A page number within the paginated result set.
         * @property pageSize integer Number of results to return per page.
         * @property search string Search query.
         * @property parentPlatform string Filter by parent platforms, for example: 1,2,3.
         * @property platforms string Filter by platforms, for example: 4,5.
         * @property stores string Filter by stores, for example: 5,6.
         * @property developers string Filter by developers, for example: 1612,18893 or valve-software,feral-interactive.
         * @property publishers string Filter by publishers, for example: 354,20987 or electronic-arts,microsoft-studios.
         * @property genres string Filter by genres, for example: 4,51 or action,indie.
         * @property tags string Filter by tags, for example: 31,7 or singleplayer,multiplayer.
         * @property creators string Filter by creators, for example: 78,28 or cris-velasco,mike-morasky.
         * @property dates string Filter by a release date, for example: 2010-01-01,2018-12-31.1960-01-01,1969-12-31.
         * @property platformsCount integer Filter by platforms count, for example: 1.
         * @property excludeCollection integer Exclude games from a particular collection, for example: 123.
         * @property excludeAdditions boolean Exclude additions.
         * @property excludeParents boolean Exclude games which have additions.
         * @property excludeGameSeries boolean Exclude games which included in a game series.
         * @property ordering string Available fields: name, released, added, created, rating.
         *                    You can reverse the sort order adding a hyphen, for example: -released.
         *
         */
        @GET("/api/games")
        suspend fun getListOfGames(
            @QueryMap map :Map<String,String>
        ): Response<PagedResponse<GameResponse>>


        /**
         * Get a list of DLC's for the game, GOTY and other editions, companion apps, etc.
         */
        @GET("api/games/{game_id}/additions")
        suspend fun getDLC(
            @Path("game_id") gamePK: String,
            @Query("page") page: Int,
            @Query("page_size") pageSize: Int
        ): Response<PagedResponse<GameResponse>>

        /**
         * Get a list of individual creators that were part of the development team.
         *
         * @property ordering string Which field to use when ordering the results.
         */
        @GET("/games/{game_id}/development-team")
        suspend fun getListOfIndividualCreators(
            @Path("game_id") gamePK: String,
            @Query("ordering") ordering: String? = null,
            @Query("page") page: Int? = null,
            @Query("page_size") pageSize: Int? = null
        ): Response<PagedResponse<GamePersonResponse>>


        /**
         * Get a list of games that are part of the same series.
         */
        @GET("/games/{game_id}/game-series")
        suspend fun getListOfGamesIsPartOfSameSeries(
            @Path("game_id") gamePK: String,
            @Query("page") page: Int? = null,
            @Query("page_size") pageSize: Int? = null
        ): Response<PagedResponse<GameResponse>>


        /**
         * Get a list of parent games for DLC's and editions.
         */
        @GET("/games/{game_id}/parent-games")
        suspend fun getListOfParentGamesDLC(
            @Path("game_id") gamePK: String,
            @Query("page") page: Int? = null,
            @Query("page_size") pageSize: Int? = null
        ): Response<PagedResponse<GameResponse>>


        /**
         * Get screenshots for the game.
         */
        @GET("api/games/{game_id}/screenshots")
        suspend fun getScreenshotsOfTheGame(
            @Path("game_id") gamePK: String,
            @Query("ordering") ordering: String? = null,
            @Query("page") page: Int? = null,
            @Query("page_size") pageSize: Int? = null
        ): Response<PagedResponse<ScreenShotResponse>>


        /**
         * Get details of the game.
         * @return @[GameSingle]
         */
        @GET("/api/games/{id}")
        suspend fun getDetailsOfGame(
            @Path("id") id: String
        ): Response<GameDetailResponse>

        /**
         * Get a list of game achievements.
         */
        @GET("/games/{id}/achievements")
        suspend fun getListOfGameAchievements(
            @Path("id") id: String
        ): Response<List<AchievementResponse>>

        /**
         * Get a list of game trailers.
         * @property id string An ID or a slug identifying this Game.
         */
        @GET("/games/{id}/movies")
        suspend fun getGameTrailers(
            @Path("id") id: String
        ): Response<PagedResponse<Any>>

        /**
         * Get a list of most recent posts from the game's subreddit.
         */
        @GET("/games/{id}/reddit")
        suspend fun getListOfMostRecentPostFromGamesSubreddit(
            @Path("id") id: String
        ): Response<PagedResponse<RecentPostResponse>>

        /**
         * Get a list of visually similar games.
         */
        @GET("/games/{id}/suggested")
        suspend fun getListOfVisualSimilarGames(
            @Path("id") id: String
        ): Response<PagedResponse<GameDetailResponse>>

        /**
         * Get streams on Twitch associated with the game .
         */
        @GET("/games/{id}/twitch")
        suspend fun getTwitchStreams(
            @Path("id") id: String
        ): Response<PagedResponse<TwitchStreamResponse>>

        /**
         * Get videos from YouTube associated with the game.
         */
        @GET("/games/{id}/youtube")
        suspend fun getYoutubeChannel(
            @Path("id") id: String
        ): Response<PagedResponse<YoutubeChannelResponse>>


    }
