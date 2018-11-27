/*    */ package jhapper;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.Point;
/*    */ import java.awt.image.ImageObserver;
/*    */ 
/*    */ 
/*    */ public class PowerUp
/*    */   extends GameObject
/*    */ {
/* 13 */   private int energy = 1;
/*    */   
/*    */   public PowerUp(Position position, int energy) {
/* 16 */     super(position);
/* 17 */     setEnergy(energy);
/* 18 */     setImage("images/powerup.gif");
/*    */   }
/*    */   
/*    */   public void paintComponent(Graphics g, ImageObserver observer)
/*    */   {
/* 23 */     if (getImage() != null) {
/* 24 */       int imgX = 15 - getImage().getWidth(observer) / 2;
/* 25 */       int imgY = 15 - getImage().getHeight(observer) / 2;
/* 26 */       imgX += getPosition().getCoords().x * 30;
/* 27 */       imgY += getPosition().getCoords().y * 30;
/* 28 */       g.drawImage(getImage(), imgX, imgY, observer);
/*    */     } else {
/* 30 */       g.setColor(Color.red);
/* 31 */       g.fillOval(getPosition().getCoords().x * 30, getPosition().getCoords().y * 30, 30, 30);
/*    */     }
/*    */   }
/*    */   
/*    */   public int getEnergy() {
/* 36 */     return this.energy;
/*    */   }
/*    */   
/*    */   public void setEnergy(int energy) {
/* 40 */     this.energy = energy;
/*    */   }
/*    */   
/*    */   public void destroy() {
/* 44 */     getPosition().setGameObject(null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Isma_\Downloads\JHapper.jar!\jhapper\PowerUp.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */