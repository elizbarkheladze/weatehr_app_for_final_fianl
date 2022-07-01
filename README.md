# Weather APP

with this application , consumer can input any city and the app will demonstrate That city in the app , it will also show the current temperature and weather

## versions and used libraries

* kotlin : 1.7.0
* WorkManager : 2.7.1
* Navigation : 2.4.2
* Retrofit: 2.9.0


## Tech info
### design
we are using singleActivity design , that shows ceratin fragments
### retrofit
we are using retrofit to get info from API and then save it in our local database that we created using sqliteHelper
### sqliteHelper
using sqliteHelper we create local database that saves given city and then returns it to viewpager

### WorkManager
we are using wokrmanage to clear our databae after certain period of time(1 Hour) and also our consumer will be notified of this action by push notification

## Test Our app
you can lone our application and open it using Andorid Studio and test our app

## Contributors
* Elizbar Kheladze
* Saba Gulibani
