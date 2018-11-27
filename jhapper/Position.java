/*     */ package jhapper;
/*     */ 
/*     */ import java.awt.Point;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Position
/*     */ {
/*     */   private Point coords;
/*     */   public static final int CELL_WIDTH = 30;
/*     */   public static final int CELL_HEIGHT = 30;
/*     */   private HashMap<Direction, Position> neighbours;
/*     */   private GameObject go;
/*     */   
/*     */   public Position(int x, int y)
/*     */   {
/*  29 */     this.coords = new Point(x, y);
/*  30 */     this.neighbours = new HashMap();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Point getCoords()
/*     */   {
/*  39 */     return this.coords;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNeighbour(Direction dir, Position neighbour)
/*     */   {
/*  49 */     this.neighbours.put(dir, neighbour);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Position getNeighbour(Direction dir)
/*     */   {
/*  59 */     return (Position)this.neighbours.get(dir);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGameObject(GameObject go)
/*     */   {
/*  68 */     this.go = go;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GameObject getGameObject()
/*     */   {
/*  77 */     return this.go;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean equals(Object aPosition)
/*     */   {
/*  89 */     if ((aPosition instanceof Position)) {
/*  90 */       Position p = (Position)aPosition;
/*  91 */       int apx = p.getCoords().x;
/*  92 */       int apy = p.getCoords().y;
/*     */       
/*  94 */       if ((apx == getCoords().x) && (apy == getCoords().y)) {
/*  95 */         return true;
/*     */       }
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Isma_\Downloads\JHapper.jar!\jhapper\Position.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */