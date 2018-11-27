/*     */ package jhapper;
/*     */ 
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.Point;
/*     */ import java.awt.image.ImageObserver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Happer
/*     */   extends MoveableObject
/*     */ {
/*     */   private Game game;
/*     */   
/*     */   public Happer(Position position)
/*     */   {
/*  19 */     super(position);
/*  20 */     super.setImage("images/happer.gif");
/*  21 */     setWeight(Integer.MAX_VALUE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void paintComponent(Graphics g, ImageObserver observer)
/*     */   {
/*  31 */     if (getImage() != null) {
/*  32 */       int imgX = 15 - getImage().getWidth(observer) / 2;
/*  33 */       int imgY = 15 - getImage().getHeight(observer) / 2;
/*  34 */       imgX += getPosition().getCoords().x * 30;
/*  35 */       imgY += getPosition().getCoords().y * 30;
/*  36 */       g.drawImage(getImage(), imgX, imgY, observer);
/*     */     } else {
/*  38 */       g.fillRect(getPosition().getCoords().x * 30, getPosition().getCoords().y * 30, 30, 30);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Direction moveTowards(Position destination)
/*     */   {
/*  51 */     Direction dir = null;Direction hDir = null;Direction vDir = null;
/*     */     
/*  53 */     if (destination.getCoords().x > getPosition().getCoords().x) {
/*  54 */       hDir = Direction.RIGHT;
/*  55 */     } else if (destination.getCoords().x < getPosition().getCoords().x) {
/*  56 */       hDir = Direction.LEFT;
/*     */     }
/*  58 */     if (destination.getCoords().y > getPosition().getCoords().y) {
/*  59 */       vDir = Direction.DOWN;
/*  60 */     } else if (destination.getCoords().y < getPosition().getCoords().y) {
/*  61 */       vDir = Direction.UP;
/*     */     }
/*  63 */     if ((hDir != null) && (vDir == null)) {
/*  64 */       dir = hDir;
/*  65 */     } else if ((hDir == null) && (vDir != null)) {
/*  66 */       dir = vDir;
/*     */     } else {
/*  68 */       boolean moveVertical = (int)Math.round(Math.random()) == 1;
/*  69 */       dir = moveVertical ? vDir : hDir;
/*     */     }
/*     */     
/*  72 */     if ((!move(dir)) && (!isTrapped()) && (dir != null))
/*     */     {
/*  74 */       Direction[] dirs = Direction.values();
/*  75 */       Direction rDir = dir;
/*     */       do {
/*  77 */         int iRDir = (int)(Math.random() * dirs.length);
/*  78 */         rDir = dirs[iRDir];
/*  79 */       } while ((rDir == dir) || (!move(rDir)));
/*  80 */       dir = rDir;
/*     */     }
/*  82 */     return dir;
/*     */   }
/*     */   
/*     */   public boolean move(Direction dir)
/*     */   {
/*  87 */     Position neighbour = getPosition().getNeighbour(dir);
/*  88 */     if (neighbour != null) {
/*  89 */       GameObject go = neighbour.getGameObject();
/*  90 */       if ((go != null) && 
/*  91 */         ((go instanceof Human))) {
/*  92 */         this.game.loseGame();
/*     */       }
/*     */     }
/*     */     
/*  96 */     return super.move(dir);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isTrapped()
/*     */   {
/* 104 */     Position hPos = getPosition();
/*     */     
/* 106 */     if ((hPos.getNeighbour(Direction.RIGHT) != null) && (hPos.getNeighbour(Direction.RIGHT).getGameObject() == null))
/*     */     {
/* 108 */       return false;
/*     */     }
/* 110 */     if ((hPos.getNeighbour(Direction.LEFT) != null) && (hPos.getNeighbour(Direction.LEFT).getGameObject() == null))
/*     */     {
/* 112 */       return false;
/*     */     }
/* 114 */     if ((hPos.getNeighbour(Direction.DOWN) != null) && (hPos.getNeighbour(Direction.DOWN).getGameObject() == null))
/*     */     {
/* 116 */       return false;
/*     */     }
/* 118 */     if ((hPos.getNeighbour(Direction.UP) != null) && (hPos.getNeighbour(Direction.UP).getGameObject() == null))
/*     */     {
/* 120 */       return false;
/*     */     }
/* 122 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGame(Game game)
/*     */   {
/* 130 */     this.game = game;
/*     */   }
/*     */ }


/* Location:              C:\Users\Isma_\Downloads\JHapper.jar!\jhapper\Happer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */