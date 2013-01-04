package nhrm.reddate;

import org.json.*;

public class RedditUser {
    String name;
    int link_karma;
    int comment_karma;

    public RedditUser(JSONObject user){
        try {
            this.name = user.getString("name");
            this.link_karma = user.getInt("link_karma");
            this.comment_karma = user.getInt("comment_karma");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
