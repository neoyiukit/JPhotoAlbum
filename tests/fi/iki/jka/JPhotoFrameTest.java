package fi.iki.jka;

import org.junit.Test;

import java.awt.event.ActionEvent;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class JPhotoFrameTest {

    @Test
    public void StartSlideShowStartsASlideShow() throws Exception {
        ActionEvent event = new ActionEvent(this,1,JPhotoMenu.A_SLIDESHOW);

        JPhotoCollection coll = new JPhotoCollection();
        JPhoto photo = new JPhoto();
        coll.add(0,photo);
        JPhotoFrame frame = new JPhotoFrame("test", coll);
        frame.actionPerformed(event);

        assertEquals(5000, frame.photoShow.interval);
    }

    @Test
    public void StartFastSlideShowStartsASlideShow() throws Exception {
        ActionEvent event = new ActionEvent(this,1,JPhotoMenu.A_FSLIDESHOW);

        JPhotoCollection coll = new JPhotoCollection();
        JPhoto photo = new JPhoto();
        coll.add(0,photo);
        JPhotoFrame frame = new JPhotoFrame("test", coll);
        frame.actionPerformed(event);

        assertEquals(1000, frame.photoShow.interval);
    }

    @Test
    public void shouldBeAbleToShowSlowThenFastSlideShow() throws Exception {
        ActionEvent fastSlideShowAction = new ActionEvent(this,1,JPhotoMenu.A_FSLIDESHOW);
        ActionEvent standardSlideShowAction = new ActionEvent(this,1,JPhotoMenu.A_SLIDESHOW);

        JPhotoCollection coll = new JPhotoCollection();
        JPhoto photo = new JPhoto();
        coll.add(0,photo);
        JPhotoFrame frame = new JPhotoFrame("test", coll);

        frame.actionPerformed(standardSlideShowAction);
        frame.actionPerformed(fastSlideShowAction);

        assertEquals(1000, frame.photoShow.interval);
    }
}