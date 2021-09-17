package CachingProxy.proxy;

import CachingProxy.model.Video;
import CachingProxy.some_cool_media_library.ThirdPartyYouTubeLib;
import CachingProxy.some_cool_media_library.ThirdPartyYoutubeClass;

import java.util.HashMap;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {

    private ThirdPartyYoutubeClass youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<>();
    private HashMap<String, Video> cacheAll = new HashMap<>();

    public YouTubeCacheProxy(ThirdPartyYoutubeClass youtubeService) {
        this.youtubeService = youtubeService;
    }

    @Override
    public HashMap<String, Video> getPopularVideo() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.getPopularVideo();
        } else {
            System.out.println("Retrieved list from cache...");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video id '" + videoId + "' cache");
        }
        return video;
    }

    public void clear() {
        cachePopular.clear();
        cacheAll.clear();
    }
}
