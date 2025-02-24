package adapter;

interface MediaPlayer {
    void play(String fileName, String fileType);
}
class VlcPlayer {
   public void playVlc(String fileName) {
       System.out.println("Playing VLC file: " + fileName);
   }
   public void playMp4(String fileName) {
       System.out.println("Playing MP4 file: " + fileName);
   }
}
// Using Class adapter
class MediaAdapter extends VlcPlayer implements MediaPlayer {
    public void play(String fileName, String fileType) {
        if (fileType.equalsIgnoreCase("mp4")) {
            playMp4(fileName);
        }else if (fileType.equalsIgnoreCase("vlc")) {
            playVlc(fileName);
        }else{
            System.out.println("Unsupported file type: " + fileType);
        }
    }
}

// Using object adapter which is dependence injection
class AdvancedMediaAdapter implements MediaPlayer {
    private final VlcPlayer vlcPlayer;
    public AdvancedMediaAdapter() {
        this.vlcPlayer = new VlcPlayer();
    }
    public void play(String fileName, String fileType) {
        if (fileType.equalsIgnoreCase("mp4")) {
            vlcPlayer.playMp4(fileName);
        }else if (fileType.equalsIgnoreCase("vlc")) {
            vlcPlayer.playVlc(fileName);
        }else{
            System.out.println("Unsupported file type: " + fileType);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        MediaAdapter adapter = new MediaAdapter();
        System.out.println("Class Adapter: " + adapter.getClass().getName());
        adapter.play("v1.mp4", "mp4");
        adapter.play("v2.vlc", "vlc");
        adapter.play("v3.mp3", "mp3");

        AdvancedMediaAdapter adapter2 = new AdvancedMediaAdapter();
        System.out.println("\n Object Adapter: " + adapter2.getClass().getName());
        adapter2.play("v1.mp4", "mp4");
        adapter2.play("v2.vlc", "vlc");
        adapter2.play("v3.mp3", "mp3");
    }
}
