package nhrm.reddate;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Reddate {

    public static void main(String[] args) {
        getRedditUserDetails("breakycpk");
    }

    public static void getRedditUserDetails(String username) {
        URL reddit = null;
        try {
            reddit = new URL("http://www.reddit.com/user/" + username + "/about.json");
            URLConnection rc = null;
            rc = reddit.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            rc.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                JSONObject result = new JSONObject(inputLine);
                JSONObject dataResult = (JSONObject)result.get("data");
                RedditUser temp = new RedditUser(dataResult);
                System.out.println(temp.name);
            }
            in.close();
        } catch (IOException e) {
            if (e.getClass() == java.io.FileNotFoundException.class) {
                System.out.println("user does not exist");
            } else {
                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
