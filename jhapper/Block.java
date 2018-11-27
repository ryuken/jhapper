/*    */ package jhapper;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.Point;
/*    */ import java.awt.image.ImageObserver;
/*    */ 
/*    */ public class Block
/*    */   extends MoveableObject
/*    */ {
/*    */   public Block(Position position)
/*    */   {
/* 14 */     super(position);
/* 15 */     super.setImage("images/brick.gif");
/* 16 */     setWeight(1);
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
/*    */     } else {
/* 28 */       g.setColor(Color.BLACK);
/* 29 */       g.fillRect(getPosition().getCoords().x * 30, getPosition().getCoords().y * 30, 30, 30);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean move(Direction dir)
/*    */   {
/* 35 */     return move(dir, 0);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean move(Direction dir, int pressureWeight)
/*    */   {
/* 46 */     if (getWeight() > pressureWeight)
/* 47 */       return false;
/* 48 */     Position neighbour = getPosition().getNeighbour(dir);
/* 49 */     if (neighbour != null) {
/* 50 */       GameObject go = neighbour.getGameObject();
/* 51 */       if (go != null) {
/* 52 */         boolean bMove = go instanceof MoveableObject;
/* 53 */         if (bMove) {
/* 54 */           MoveableObject mObject = (MoveableObject)go;
/* 55 */           if (mObject.move(dir, pressureWeight)) {
/* 56 */             return super.move(dir, pressureWeight);
/*    */           }
/* 58 */           return false;
/*    */         }
/*    */         
/* 61 */         return false;
/*    */       }
/*    */       
/* 64 */       return super.move(dir, pressureWeight);
/*    */     }
/*    */     
/* 67 */     return super.move(dir, pressureWeight);
/*    */   }
/*    */ }


/* Location:              C:\Users\Isma_\Downloads\JHapper.jar!\jhapper\Block.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */