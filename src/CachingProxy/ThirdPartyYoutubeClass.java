package CachingProxy;

import CachingProxy.Model.Video;

import java.util.HashMap;

public class ThirdPartyYoutubeClass implements ThirdPartyYouTubeLib {

    @Override
    public HashMap<String, Video> getPopularVideo() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    // -----------------------------------------------------------------------
    // Fake methods to simulate network activity. They as slow as a real life.
    private int random(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void connectToServer(String server) {
        System.out.println("Connecting to: " + server + "... ");
        experienceNetworkLatency();
        System.out.println("Connected!");
    }

    private HashMap<String, Video> getRandomVideos() {
        System.out.println("Downloading popular videos:");

        experienceNetworkLatency();

        HashMap<String, Video> maps = new HashMap<>();
        maps.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
        maps.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
        maps.put("dancesvideoo", new Video("asdfas3ffasd", "Dancing video.mpq"));
        maps.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
        maps.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programing lesson#1.avi"));

        System.out.println("Done!");
        return maps;
    }

    private Video getSomeVideo(String videoId) {
        System.out.print("Downloading video... ");

        experienceNetworkLatency();
        Video video = new Video(videoId, "Some Video Title");

        System.out.println("Done!");
        return video;
    }
}
