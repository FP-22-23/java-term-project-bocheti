# Second term proyect for Programming fundamentals (Year 22/23)


Author: Salvador Ramón Espinosa Merino

This proyect is intended to analize the data about tweets that the user WeRateDogs (https://twitter.com/dog_rates?s=20) tweeted between November 2015 and August 2017. Said user content consists on funny, wholesome and harmless comments about a dog sent to him by a follower alongside with a picture of the dog and a rating that is normally above the maximum mark. This dataset was downloaded from Kaggle (https://www.kaggle.com/datasets/catherinenewcomb/weratedogs-tweepy-archive) and has been modified to remove the source as it was very redundant having both the url and the expanded one, as well as also removing rating numerator and denominator to just retain the rating value.


### Structure of the proyect's folders

- **/src**: It contains all of the Java packages:
    - **/fp**: Package that contains all of the code packages in itself.
    - **/test**: Package that contains the test classes to test the main ones.
    - **/types**: Packages that contains the main and auxliary classes and its definitions.
    - **/utils**: Package that contains utility classes.
- **/data**: Contains the dataset of the proyect:
    - **twitter_dogs.csv**: CSV file with the tweets' data.
- **/doc**: Contains the README file:
    - **README.md**: This file that you are reading right now, meant to explain the work process of creating this proyect and the way it works 


### Structure of the dataset

Each dataset row collects information about a different one between the two thousand total ones. The 8 different characteristics given are the following ones:
- **tweet_id**: Integer number that identifies the tweet
- **favorite_count**: Integer number of favs the tweet got
- **retweet_count**: Integer number of retweets the tweet got
- **timestamp**: Date and hour of the moment the tweet was posted
- **text**: Text in the tweet in itself
- **expanded_urls**: Expanded URL link of the tweet
- **name**: Name of the dog the tweet is talking about (if it is not specified, = None)
- **rating_score**: Rating given to the dog out of 1 (normally more than 1)

### Deliveries

- **Delivery 1**:
    - First and foremost, created the proyect and its folders (src, data and doc, including the .csv file in data and this README file in doc) and packages (types, test and utils)
    - **types package**: Added the main class Tweet, which contains the following code:
        Established the class' prpoperties: Id id (identifier for each tweet, also establishes equity), Integer favs, Integer rts, LocalDateTime datetime (alongside id, establishes natural order), String name, Double rating, ArrayList<String> wordlist (List of words that refer to dog, like doggo, pup or pupper, and extra ones can be added with the defined addWord(String s) method), as well as the derived ones, Boolean hasName (true if the tweet indicates the name of the dog and false if it doesn't) and dogFame fame (enum that indicates the amount of retweets the tweet had, can have the values VERY_HIGH,HIGH,MEDIUM,LOW or VERY_LOW). Of course, the getters and setters (only the property String name is modifiable) have also been added, as well as two constructors with its constraints (id can't be null and rating can't be negative), the toString() method and the previously mentioned equity and natural order criteria.
    - **test package**: Tested all of the added methods.
    - **utils package**:  Added the Checkers class in order to apply constraints to the constructors


- **Delivery 2**:
    - Created factory with the following methods:
        - *Tweet parseLine(String line)*: Reads a String, which is a line of the csv file, and generates from it a Tweet object.
        - *Tweets read(String fileName)*: Reads a csv file and, using the parseLine method, transforms it into a Tweets object.

    - Created the container type Tweets, with the following methods:
        - Constructors *Tweets(Stream<Tweet>)* and *Tweets()*: Create new Tweets object (one with the stream as the content of the attribute tweets, which is a list of tweets, the other one with its tweets attribute as an empty list)
        - *Integer getNumberTweets()*: Returns the number of Tweet objects the Tweets object contains.
        - *void addTweet(Tweet t)*: Adds a given Tweet object to the Tweets object.
        - *void addAllTweets(List<Tweet> tweetlist)*: Adds all Tweets from the given parameter Tweet list tweetlist to the Tweets object. 
        - *void deleteTweet(Tweet t)* and *void deleteTweet(int i)*: Deletes a Tweet object from the Tweets object (one deletes a certain parameter object, the other one deletes the object whose index is the parameter given )
        - *Boolean checkName(String name)*: Returns true if the parameter string name is equal to the attribute name of any of the Tweet objects of the Tweets object.
        - *Double averageLikesPerName(String name)*: Returns the average number of likes the Tweet objects whose attribute name is equal to the parameter gets (if no Tweet object has that name, returns 0).
        - **
        - *Map<String,List<Tweet>> tweetsPerName()*: Returns a Map in which the keys are the names of the dogs, and the values are a list of the Tweet object whose attribute name coincides with each key.
        - **:

    - Created the test class *TestTweets* , in which all methods perfomring sequential treatments were tested
    