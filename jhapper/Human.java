/*     */ package jhapper;
/*     */ 
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.Point;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.image.ImageObserver;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Human
/*     */   extends MoveableObject
/*     */ {
/*     */   private Game game;
/*     */   private int energy;
/*     */   private Timer puChecker;
/*     */   private Timer warnPlayer;
/*     */   
/*     */   public Human(Position position)
/*     */   {
/*  25 */     super(position);
/*  26 */     super.setImage("images/human.gif");
/*     */     
/*  28 */     this.puChecker = new Timer(9000, new ActionListener()
/*     */     {
/*     */ 
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/*     */ 
/*  34 */         if (Human.this.isPoweredUp()) {
/*  35 */           Human.this.warnPlayer.stop();
/*  36 */           Human.this.energy = 0;
/*  37 */           Human.this.setImage("images/human.gif");
/*     */         }
/*     */         
/*     */       }
/*  41 */     });
/*  42 */     this.warnPlayer = new Timer(7000, new ActionListener()
/*     */     {
/*     */ 
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/*     */ 
/*  48 */         if (Human.this.isPoweredUp()) {
/*  49 */           Human.this.setImage("images/flash.gif");
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void paintComponent(Graphics g, ImageObserver observer)
/*     */   {
/*  61 */     if (getImage() != null) {
/*  62 */       int imgX = 15 - getImage().getWidth(observer) / 2;
/*  63 */       int imgY = 15 - getImage().getHeight(observer) / 2;
/*  64 */       imgX += getPosition().getCoords().x * 30;
/*  65 */       imgY += getPosition().getCoords().y * 30;
/*  66 */       g.drawImage(getImage(), imgX, imgY, observer);
/*     */     } else {
/*  68 */       g.fillRect(getPosition().getCoords().x * 30, getPosition().getCoords().y * 30, 30, 30);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean move(Direction dir)
/*     */   {
/*  74 */     Position neighbour = getPosition().getNeighbour(dir);
/*  75 */     if (neighbour != null) {
/*  76 */       GameObject go = neighbour.getGameObject();
/*  77 */       if (go != null) {
/*  78 */         if (((go instanceof MoveableObject)) && (!(go instanceof Happer))) {
/*  79 */           MoveableObject mObject = (MoveableObject)go;
/*  80 */           if (mObject.move(dir, this.energy)) {
/*  81 */             return super.move(dir);
/*     */           }
/*  83 */           return false;
/*     */         }
/*  85 */         if ((go instanceof PowerUp)) {
/*  86 */           this.energy += ((PowerUp)go).getEnergy();
/*  87 */           ((PowerUp)go).destroy();
/*  88 */           setImage("images/StrongHuman.gif");
/*  89 */           if (this.puChecker.isRunning()) {
/*  90 */             this.puChecker.restart();
/*  91 */             this.warnPlayer.restart();
/*     */           } else {
/*  93 */             this.puChecker.start();
/*  94 */             this.warnPlayer.start();
/*     */           }
/*  96 */           return super.move(dir); }
/*  97 */         if ((go instanceof Happer)) {
/*  98 */           this.game.loseGame();
/*  99 */           return false;
/*     */         }
/* 101 */         return false;
/*     */       }
/*     */       
/* 104 */       return super.move(dir);
/*     */     }
/*     */     
/* 107 */     return super.move(dir);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGame(Game game)
/*     */   {
/* 116 */     this.game = game;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isPoweredUp()
/*     */   {
/* 124 */     if (this.energy > 0) {
/* 125 */       return true;
/*     */     }
/* 127 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Isma_\Downloads\JHapper.jar!\jhapper\Human.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */