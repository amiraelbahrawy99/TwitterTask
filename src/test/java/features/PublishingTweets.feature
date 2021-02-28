Feature: Publishing Tweets
  I want to check functionality of Tweet Publishing

  @TweetpublishingInPlaintext @successful
  Scenario Outline: Publish a tweet include plain text only
    Given user is loggedin Twitter with his credentials "<phone>" ,"<password>"
    When user send plain text "<Tweet>"
    Then "<Tweet>" is published successfully

    Examples: 
      | phone       | password  | Tweet               |
      | 01150362442 | Mario1995 | Anime Lover is here |


  @ReplyingToOwnTweet @successful
  Scenario Outline: Replying to own published tweet
    Given user is loggedin Twitter with his credentials "<phone>" ,"<password>"
    When user send plain text "<Tweet>"
    And user reply to his "<Tweet>" with "<AnotherTweet>"
    Then "<AnotherTweet>" reply is published successfully

    Examples: 
      | phone       | password  | Tweet        | AnotherTweet     |
      | 01150362442 | Mario1995 | I love Anime | specially Naruto |


  @SameTweetTwice @failure
  Scenario Outline: User can't send same Tweet twice
    Given user is loggedin Twitter with his credentials "<phone>" ,"<password>"
    When user send plain text "<Tweet>"
    And Try to send same "<Tweet>" again
    Then "<Tweet>" isn't sent and user get error message

    Examples: 
      | phone       | password  | Tweet                |
      | 01150362442 | Mario1995 | DeathNote is amazing |
