package CachingProxy.some_cool_media_library;

import CachingProxy.model.Video;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> getPopularVideo();

    Video getVideo(String videoId);
}
