/*    */ package jhapper;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.Point;
/*    */ import java.awt.image.ImageObserver;
/*    */ 
/*    */ public class Box
/*    */   extends MoveableObject
/*    */ {
/*    */   public Box(Position position)
/*    */   {
/* 14 */     super(position);
/* 15 */     super.setImage("images/box.gif");
/* 16 */     setWeight(0);
/*    */   }
/*    */   
/*    */   public void paintComponent(Graphics g, ImageObserver observer)
/*    */   {
/* 21 */     if (getImage() != null) {
/* 22 */       int imgX = 15 - getImage().getWidth(observer) / 2;
/* 23 */       int imgY = 15 - getImage().getHeight(observer) / 2;
/* 24 */       imgX += getPosition().getCoords().x * 30;
/* 25 */       imgY += getPosition().getCoords().y * 30;
/* 26 */       g.drawImage(getImage(), imgX, imgY, observer);
/*    */     }
/*    */     else {
/* 29 */       g.setColor(Color.BLUE);
/* 30 */       g.fillRect(getPosition().getCoords().x * 30, getPosition().getCoords().y * 30, 30, 30);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean move(Direction dir)
/*    */   {
/* 36 */     return move(dir, 1);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean move(Direction dir, int pressureWeight)
/*    */   {
/* 48 */     if (getWeight() > pressureWeight)
/* 49 */       return false;
/* 50 */     Position neighbour = getPosition().getNeighbour(dir);
/* 51 */     if (neighbour != null) {
/* 52 */       GameObject go = neighbour.getGameObject();
/* 53 */       if (go != null) {
/* 54 */         if ((go instanceof MoveableObject)) {
/* 55 */           MoveableObject mObject = (MoveableObject)go;
/* 56 */           if (mObject.move(dir, pressureWeight)) {
/* 57 */             return super.move(dir, pressureWeight);
/*    */           }
/* 59 */           return false;
/*    */         }
/*    */         
/* 62 */         return false;
/*    */       }
/*    */       
/* 65 */       return super.move(dir, pressureWeight);
/*    */     }
/*    */     
/* 68 */     return super.move(dir, pressureWeight);
/*    */   }
/*    */ }


/* Location:              C:\Users\Isma_\Downloads\JHapper.jar!\jhapper\Box.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */