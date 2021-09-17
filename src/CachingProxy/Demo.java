package CachingProxy;

import CachingProxy.downloader.YoutubeDownloader;
import CachingProxy.proxy.YouTubeCacheProxy;
import CachingProxy.some_cool_media_library.ThirdPartyYoutubeClass;

public class Demo {

    public static void main(String[] args) {
        YoutubeDownloader naiveDownloader = new YoutubeDownloader(new ThirdPartyYoutubeClass());
        YoutubeDownloader smartDownloader = new YoutubeDownloader(new YouTubeCacheProxy());

        test(naiveDownloader);
        test(smartDownloader);
    }

    private static long test(YoutubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideo();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideo();
        downloader.renderVideoPage("dancesvideoo");

        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }

}
