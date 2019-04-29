# tg application to get Top Grossing data

This application runs locally with the command mvn clean spring-boot:run

## Read top 10, 20, 50, 100, 200 games from given market

EndPoint url : http://localhost:8080/api/games/getTop?topRank=

eg: http://localhost:8080/api/games/getTop?topRank=10

## List all games that have entered to top 10, 20, 50 between now and given amount of days.

Input params: topEntry- 10 or 20 or 50 to get Top10Entry, Top20Entry and Top50Entry respectively,
              days

EndPoint url : http://localhost:8080/api/games/getTopEntry?topEntry=&days=

Eg: http://localhost:8080/api/games/getTopEntry?topEntry=20&days=800

## Create and interface which can be used to mark given game as an favourite.

There are two URLs for this interface.
HTTP GET request will return all games which are favorite
HTTP PUT request will set the game as favorite whose id is passed as input param

EndPoint url for HTTP GET: http://localhost:8080/api/games/getFavorites

EndPoint url for HTTP PUT: http://localhost:8080/api/games/setFavorites?id=

Input params: Object id
eg: http://localhost:8080/api/games/setFavorites?id=57bfd059ce6f244ba212e557

Output json: 

{
    "id": {
        "timestamp": 1472188505,
        "machineIdentifier": 13528868,
        "processIdentifier": 19362,
        "counter": 1238359,
        "timeSecond": 1472188505,
        "time": 1472188505000,
        "date": "2016-08-26T05:15:05.000+0000"
    },
    "name": "Gardenscapes",
    "rank": 10,
    "rankMonth": 24,
    "rankWeek": 11,
    "rankYesterday": 10,
    "favorite": true
}

## Fetch rank history of give game from given market in three different ranges; daily, weekly and monthly

This HTTP GET request will fetch rankMonth,rankWeek and rankYesterday of the game and market given as input params

Endpoint url: http://localhost:8080/api/games/getRankHistory?name=&market=

Input Params: Game Name , Market

request url: http://localhost:8080/api/games/getRankHistory?name=Gardenscapes&market=fi

Output json: 

{
    "id": {
        "timestamp": 1472167628,
        "machineIdentifier": 13528868,
        "processIdentifier": 19362,
        "counter": 1236389,
        "time": 1472167628000,
        "date": "2016-08-25T23:27:08.000+0000",
        "timeSecond": 1472167628
    },
    "name": "Gardenscapes",
    "rank": 22,
    "rankMonth": 32,
    "rankWeek": 25,
    "rankYesterday": 26,
    "favorite": false
}





