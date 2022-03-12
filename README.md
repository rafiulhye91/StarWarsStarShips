# StarWarsStarShips
![demo](https://user-images.githubusercontent.com/17979110/158035375-36d2af14-1d25-496d-8923-082546d791e9.gif)

StartwarsStarships is an Android project that makes an API call on https://swapi.dev/api/ url, get json response of Starships and make it visible to the UI.
The purpose of this project is making a simple REST API request by following the clean architecture concept while using a number of librarires.


**Architecture/ Design pattern: **

MVVM, Clean architecture with defined Usecase 

**Tools/Libs: **

Retrofit2 REST client\
GSon converter for json responses\
OkHttp3 client\
Coroutines for Asynchronous call\
Viewmodel and Livedata for preparing and managing the data for the Activity and Fragment\
Dagger-hilt dependency injection

