/*    */ package jhapper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class MoveableObject
/*    */   extends GameObject
/*    */ {
/* 11 */   private int weight = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public MoveableObject(Position position)
/*    */   {
/* 18 */     super(position);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean move(Direction dir)
/*    */   {
/* 28 */     return move(dir, getWeight());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean move(Direction dir, int pressureWeight)
/*    */   {
/* 38 */     if (getWeight() > pressureWeight)
/* 39 */       return false;
/* 40 */     Position neighbour = getPosition().getNeighbour(dir);
/* 41 */     if (neighbour != null) {
/* 42 */       if (neighbour.getGameObject() != null) {
/* 43 */         return false;
/*    */       }
/* 45 */       getPosition().setGameObject(null);
/* 46 */       neighbour.setGameObject(this);
/* 47 */       setPosition(neighbour);
/* 48 */       return true;
/*    */     }
/*    */     
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int getWeight()
/*    */   {
/* 56 */     return this.weight;
/*    */   }
/*    */   
/*    */   public void setWeight(int weight) {
/* 60 */     this.weight = weight;
/*    */   }
/*    */ }


/* Location:              C:\Users\Isma_\Downloads\JHapper.jar!\jhapper\MoveableObject.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */