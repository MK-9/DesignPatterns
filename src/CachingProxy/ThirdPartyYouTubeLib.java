package CachingProxy;

import CachingProxy.Model.Video;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> getPopularVideo();

    Video getVideo(String videoId);
}
