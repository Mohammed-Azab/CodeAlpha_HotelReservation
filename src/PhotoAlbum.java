import java.util.ArrayList;
import java.io.File;

public class PhotoAlbum {
    private ArrayList<String> photos;

    public PhotoAlbum() {
        this.photos = new ArrayList<>();
    }

    public void addPhoto(String relativePath) {
        String absolutePath = new File(relativePath).getAbsolutePath();
        this.photos.add(absolutePath);

    }

    public void removePhoto(String photo) {
        this.photos.remove(photo);
    }

    public void displayPhotos() {
        for (String photo : this.photos) {
            System.out.println(photo);
        }
    }

}
