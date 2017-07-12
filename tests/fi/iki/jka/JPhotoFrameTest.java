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

        JPhotoFrameMock frame = new JPhotoFrameMock();
        frame.actionPerformed(event);

        assertEquals(5000, frame.getInterval());
    }

    @Test
    public void StartFastSlideShowStartsASlideShow() throws Exception {
        ActionEvent event = new ActionEvent(this,1,JPhotoMenu.A_FSLIDESHOW);

        JPhotoFrameMock frame = new JPhotoFrameMock();
        frame.actionPerformed(event);

        assertEquals(1000, frame.getInterval());
    }

    @Test
    public void shouldBeAbleToShowSlowThenFastSlideShow() throws Exception {
        ActionEvent fastSlideShowAction = new ActionEvent(this,1,JPhotoMenu.A_FSLIDESHOW);
        ActionEvent standardSlideShowAction = new ActionEvent(this,1,JPhotoMenu.A_SLIDESHOW);

        JPhotoFrameMock frame = new JPhotoFrameMock();

        frame.actionPerformed(standardSlideShowAction);
        frame.actionPerformed(fastSlideShowAction);

        assertEquals(1000, frame.getInterval());
    }
}

    class JPhotoFrameMock extends JPhotoFrame {
        protected JPhotoFrameMock() throws Exception {
        }

        @Override
        protected void CreateAndRunSlideShow(JPhotoCollection photos, int interval, JPhotoList list) {
        }

        @Override
        public void setTitle(){
        }
}