
package org.micromanager.pointandshootanalysis.display;

import georegression.struct.point.Point2D_I32;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.micromanager.data.Image;
import org.micromanager.display.DisplaySettings;
import org.micromanager.display.overlay.AbstractOverlay;
import org.micromanager.pointandshootanalysis.data.ParticleData;

/**
 *
 * @author nico
 */
public class Overlay extends AbstractOverlay {
   private final String TITLE = "Point and Shoot Overlay";
   private final List<Map<Integer, ParticleData>> tracks_;
   private final Map<Integer, List<ParticleData>> tracksIndexedByFrame_;
   private final int symbolLenght_ = 30;
   private final Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.CYAN, Color.MAGENTA};
   private final Color maskColor_ = new Color(255, 125, 10);
   
   public Overlay(List<Map<Integer, ParticleData>> tracks) {
      tracks_ = tracks;
      // index tracks by frame for quick look up when we need it
      tracksIndexedByFrame_ = new TreeMap<>();
      tracks_.forEach( (track) -> {
         track.entrySet().forEach((entry) -> {
            List<ParticleData> particlesInFrame = tracksIndexedByFrame_.get(entry.getKey());
            if (particlesInFrame == null) {
               particlesInFrame = new ArrayList<>();
            }
            particlesInFrame.add(entry.getValue());
            tracksIndexedByFrame_.put(entry.getKey(), particlesInFrame);
         });
      });
      super.setVisible(true);
   }
   
   @Override
   public String getTitle() {
      return TITLE;
   }
   
   /**
    * {@inheritDoc}
    * <p>
    * 
    */
   @Override
   public void paintOverlay(Graphics2D g, Rectangle screenRect,
         DisplaySettings displaySettings,
         List<Image> images, Image primaryImage,
         Rectangle2D.Float imageViewPort)
   {
      // TODO: make sure this is our dataviewer
      Integer frame = primaryImage.getCoords().getTimePoint();
      if (tracksIndexedByFrame_.get(frame) != null) {
         final double zoomRatio = imageViewPort.width / screenRect.width;
         final int halfLength = symbolLenght_ / 2;

         // Draw the pattern in image pixel coordinates by applying a transform
         Graphics2D gTfm = (Graphics2D) g.create();
         gTfm.transform(AffineTransform.
                 getScaleInstance(1.0 / zoomRatio, 1.0 / zoomRatio));
         gTfm.transform(AffineTransform.
                 getTranslateInstance(-imageViewPort.x, -imageViewPort.y));
         // Stroke width should be 1.0 in screen coordinates
         gTfm.setStroke(new BasicStroke((float) zoomRatio));
         
         int colorIndex = 0;
         for (ParticleData p : tracksIndexedByFrame_.get(frame)) {
            gTfm.setColor(maskColor_);
            p.getMask().forEach((point) -> {
               g.draw(new Line2D.Float(point.x, point.y, point.x, point.y));
            });
            gTfm.setColor(colors[colorIndex]);
            colorIndex++;
            if (colorIndex >= colors.length) { 
               colorIndex = 0; 
            }
            drawMarker1(gTfm, p.getCentroid(), halfLength, halfLength / 2);
            
         }
      }
   }
   
   
   /**
    * Draws:
    *      |
    *    -   -
    *      |
    * 
    * @param g - graphics environment to draw on
    * @param p - 
    * @param width1
    * @param width2 
    */
   
   private void drawMarker1(Graphics2D g, Point2D_I32 p, int width1, int width2) {
      g.draw(new Line2D.Float(p.x, p.y - width1, p.x, p.y - width1 + width2));
      g.draw(new Line2D.Float(p.x, p.y + width1, p.x, p.y + width1 - width2));
      g.draw(new Line2D.Float(p.x - width1, p.y, p.x - width1 + width2, p.y));
      g.draw(new Line2D.Float(p.x + width1, p.y, p.x + width1 - width2, p.y));
   }
   

   
}
