package CachingProxy.downloader;

import CachingProxy.model.Video;
import CachingProxy.some_cool_media_library.ThirdPartyYouTubeLib;

import java.util.HashMap;

public class YoutubeDownloader implements YoutubeDownloaderInterface {

    private final ThirdPartyYouTubeLib api;

    public YoutubeDownloader(ThirdPartyYouTubeLib api) {
        this.api = api;
    }

    @Override
    public void renderVideoPage(String videoId) {
        Video video = api.getVideo(videoId);
        System.out.println("\n-------------------------------");
        System.out.println("Video page (imagine fancy HTML)");
        System.out.println("ID: " + video.getId());
        System.out.println("Title: " + video.getTitle());
        System.out.println("Data: " + video.getData());
        System.out.println("-------------------------------\n");
    }

    @Override
    public void renderPopularVideo() {
        HashMap<String, Video> list = api.getPopularVideo();
        System.out.println("\n-------------------------------");
        System.out.println("Most popular videos on YouTube (imagine fancy HTML)");
        for (Video video : list.values()) {
            System.out.println("ID: " + video.getId() + " / Title: " + video.getTitle());
        }
        System.out.println("-------------------------------\n");
    }
}
