/*    */ package jhapper;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.image.ImageObserver;
/*    */ import java.net.URL;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class GameObject
/*    */ {
/*    */   protected Position position;
/*    */   private Image image;
/*    */   
/*    */   public GameObject(Position position)
/*    */   {
/* 26 */     this.position = position;
/* 27 */     position.setGameObject(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Position getPosition()
/*    */   {
/* 36 */     return this.position;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setPosition(Position position)
/*    */   {
/* 44 */     this.position = position;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setImage(Image img)
/*    */   {
/* 53 */     this.image = img;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setImage(String imagePath)
/*    */   {
/* 62 */     Toolkit kit = Toolkit.getDefaultToolkit();
/* 63 */     URL url = ClassLoader.getSystemResource(imagePath);
/* 64 */     setImage(kit.getImage(url));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Image getImage()
/*    */   {
/* 72 */     return this.image;
/*    */   }
/*    */   
/*    */   public abstract void paintComponent(Graphics paramGraphics, ImageObserver paramImageObserver);
/*    */ }


/* Location:              C:\Users\Isma_\Downloads\JHapper.jar!\jhapper\GameObject.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */