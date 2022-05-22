import java.util.HashMap;
import java.util.Map;

public class StoryBoard {
    private final int location;
    private final String description;
    private final Map<String, Integer> paths;

    public StoryBoard(int location, String description) {
        this.location = location;
        this.description = description;
        this.paths = new HashMap<String, Integer>();
        //this.paths.put("Q",0);
    }

    public int getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getPaths() {
        return new HashMap<>(paths);
    }

    public void addPaths(String des, int location) {
        paths.put(des, location);
    }
}
