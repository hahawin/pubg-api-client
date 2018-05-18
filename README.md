# Pubg API Client
Java library to interface with the PUBG developer API.

[![Build Status](https://travis-ci.org/SoftwareSandbox/pubg-api-client.svg)](https://travis-ci.org/SoftwareSandbox/pubg-api-client)

## Authenticating towards the PUBG developer API
There are two ways to authenticate to the PUBG developer API, choose the one you find the most convenient:
- Provide the key as an argument in the main constructor of the `PubgApiClient` class
- Place the key in the predefined location shown below

> If you provide keys via both channels, the key provided in the constructor argument of the `PubgApiClient` class will take precedence.

> To retrieve an API key, visit the [PUBG developer API website](https://documentation.playbattlegrounds.com/en/api-keys.html) and follow the instructions.

### API key via PubgApiClient constructor
Provide the api key in the constructor of the `PubgApiClient` class.

```java
import com.softwaresandbox.pubgclient.PubgApiClient;

public class DemoTime {
    
    public static void main(String[] args) {
        PubgApiClient pubgApiClient = new PubgApiClient("<api-key>");
        // ..
    }
}
```

### API key in the predefined location
Place the property `development=<api-key>` in a `.key/pubgapi.key` file in your user's home directory:

- Execute the following commands:
    ```bash
    cd ~
    mkdir .key
    nano .key/pubgapi.key
    ```
- Add `development=<api-key>` to the opened file

## Using the library
Create an instance of the `PubgApiClient` class and call retrieve the desired information by calling the corresponding methods.  

Example usage:
```java
import com.softwaresandbox.pubgclient.PubgApiClient;
import com.softwaresandbox.pubgclient.PubgApiClientException;
import com.softwaresandbox.pubgclient.model.DataList;
import com.softwaresandbox.pubgclient.model.player.MatchId;
import com.softwaresandbox.pubgclient.model.player.PlayerResponse;

public class DemoTime {

    public static void main(String[] args) {
        String playerName = "shroud";
        
        PubgApiClient pubgApiClient = new PubgApiClient();
        Optional<PlayerResponse> potentialPlayerResponse = pubgApiClient.getPlayerByName(playerName, "pc-na");
    
        DataList<MatchId> matchIds = potentialPlayerResponse
                .map(playerResponse -> playerResponse.getPlayer().getPlayerRelationships().getMatchIds())
                .orElseThrow(() -> new IllegalArgumentException("Player " + playerName + " not found!"));
    
        System.out.println(matchIds.getData().size() + " epic matches found for player " + playerName);
    }
}
```

Made with :heart: by [Cegeka](https://www.cegeka.com/).