/*     */ package jhapper;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Game
/*     */ {
/*     */   private HapperPanel hp;
/*     */   private Position[][] positions;
/*     */   public static final int MIN_FIELD_SIZE = 8;
/*     */   public static final int MAX_FIELD_SIZE = 20;
/*  21 */   private int fieldWidth = 20;
/*  22 */   private int fieldHeight = 20;
/*     */   private Happer happer;
/*     */   private Human human;
/*  25 */   private int numberOfBoxes = 30;
/*  26 */   private int numberOfBlocks = 20;
/*     */   private GameObject[] gameObjects;
/*     */   private PowerUp[] powerups;
/*  29 */   private boolean paused = true;
/*     */   
/*     */   private Timer happerWalker;
/*     */   
/*     */   private Timer humanWalker;
/*     */   
/*  35 */   private boolean lost = false;
/*     */   
/*     */ 
/*     */ 
/*  39 */   private boolean won = false;
/*     */   
/*     */ 
/*     */ 
/*     */   public Game()
/*     */   {
/*  45 */     initGame();
/*     */     
/*  47 */     this.humanWalker = new Timer(50, new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*  50 */         if (!Game.this.paused) {
/*  51 */           Game.this.processKeys();
/*     */         }
/*  53 */         if (Game.this.hp != null)
/*  54 */           Game.this.hp.repaint();
/*     */       }
/*  56 */     });
/*  57 */     this.humanWalker.start();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  63 */     this.happerWalker = new Timer(300, new ActionListener()
/*     */     {
/*     */ 
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/*     */ 
/*  69 */         if (!Game.this.paused) {
/*  70 */           Game.this.walkHapper();
/*     */         }
/*  72 */         Game.this.hp.repaint();
/*     */       }
/*  74 */     });
/*  75 */     this.happerWalker.start();
/*     */   }
/*     */   
/*     */   public void setDimension(int field) {
/*  79 */     this.fieldWidth = field;
/*  80 */     this.fieldHeight = field;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHapperSpeed(int speed)
/*     */   {
/*  88 */     this.happerWalker.stop();
/*  89 */     this.happerWalker.setDelay(speed);
/*  90 */     this.happerWalker.start();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHapperPanel(HapperPanel hp)
/*     */   {
/*  99 */     this.hp = hp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void initGame()
/*     */   {
/* 106 */     if (this.fieldHeight < 4) {
/* 107 */       this.fieldHeight = 8;
/*     */     }
/* 109 */     if (this.fieldWidth < 4) {
/* 110 */       this.fieldWidth = 8;
/*     */     }
/* 112 */     this.numberOfBlocks = ((this.fieldWidth - 4) * (this.fieldHeight - 4) / 4);
/* 113 */     this.numberOfBoxes = ((this.fieldWidth - 4) * (this.fieldHeight - 4) / 4);
/*     */     
/* 115 */     this.gameObjects = new GameObject[this.numberOfBlocks + this.numberOfBoxes];
/* 116 */     this.powerups = new PowerUp[2];
/* 117 */     createPositions();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void startGame()
/*     */   {
/* 124 */     this.paused = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void stopGame()
/*     */   {
/* 131 */     this.paused = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void resetGame()
/*     */   {
/* 138 */     initGame();
/* 139 */     this.paused = true;
/* 140 */     this.lost = false;
/* 141 */     this.won = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void createPositions()
/*     */   {
/* 148 */     this.positions = new Position[this.fieldWidth][this.fieldHeight];
/* 149 */     for (int col = 0; col < this.positions.length; col++) {
/* 150 */       for (int row = 0; row < this.positions[col].length; row++) {
/* 151 */         this.positions[col][row] = new Position(col, row);
/*     */       }
/*     */     }
/*     */     
/* 155 */     for (int col = 0; col < this.positions.length; col++) {
/* 156 */       for (int row = 0; row < this.positions[col].length; row++) {
/* 157 */         if (col < this.positions.length - 1) {
/* 158 */           this.positions[col][row].setNeighbour(Direction.RIGHT, this.positions[(col + 1)][row]);
/*     */         }
/* 160 */         if (row < this.positions[col].length - 1) {
/* 161 */           this.positions[col][row].setNeighbour(Direction.DOWN, this.positions[col][(row + 1)]);
/*     */         }
/* 163 */         if (col > 0) {
/* 164 */           this.positions[col][row].setNeighbour(Direction.LEFT, this.positions[(col - 1)][row]);
/*     */         }
/* 166 */         if (row > 0) {
/* 167 */           this.positions[col][row].setNeighbour(Direction.UP, this.positions[col][(row - 1)]);
/*     */         }
/*     */       }
/*     */     }
/* 171 */     setPositions();
/* 172 */     if (this.happer.isTrapped()) {
/* 173 */       createPositions();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Position[][] getPositions()
/*     */   {
/* 182 */     return this.positions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void walkHapper()
/*     */   {
/* 189 */     if ((this.paused) || (this.won)) {
/* 190 */       return;
/*     */     }
/* 192 */     if (this.happer.isTrapped()) {
/* 193 */       winGame();
/*     */     }
/* 195 */     Position humanPosition = this.human.getPosition();
/* 196 */     this.happer.moveTowards(humanPosition);
/* 197 */     if (this.happer.getPosition().equals(humanPosition)) {
/* 198 */       loseGame();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void setPositions()
/*     */   {
/* 206 */     Position humanPos = this.positions[0][0];
/* 207 */     this.human = new Human(humanPos);
/* 208 */     this.human.setGame(this);
/* 209 */     Position happerPos = this.positions[(this.positions.length - 1)][(this.positions.length - 1)];
/* 210 */     this.happer = new Happer(happerPos);
/* 211 */     this.happer.setGame(this);
/*     */     
/* 213 */     for (int i = 0; i < this.gameObjects.length; i++)
/*     */     {
/*     */       Position pos;
/*     */       do
/*     */       {
/* 218 */         int rx = (int)(Math.random() * (this.positions.length - 4)) + 2;
/* 219 */         int ry = (int)(Math.random() * (this.positions.length - 4)) + 2;
/* 220 */         pos = this.positions[rx][ry];
/* 221 */       } while (pos.getGameObject() != null);
/* 222 */       if (i < this.numberOfBlocks) {
/* 223 */         this.gameObjects[i] = new Block(pos);
/*     */       } else {
/* 225 */         this.gameObjects[i] = new Box(pos);
/*     */       }
/*     */     }
/*     */     
/* 229 */     for (int i = 0; i < this.powerups.length; i++)
/*     */     {
/*     */       Position pos;
/*     */       do
/*     */       {
/* 234 */         int rx = (int)(Math.random() * (this.positions.length - 4)) + 2;
/* 235 */         int ry = (int)(Math.random() * (this.positions.length - 4)) + 2;
/* 236 */         pos = this.positions[rx][ry];
/* 237 */       } while (pos.getGameObject() != null);
/* 238 */       this.powerups[i] = new PowerUp(pos, 1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void processKeys()
/*     */   {
/* 247 */     if ((this.paused) || (this.lost)) {
/* 248 */       return;
/*     */     }
/*     */     
/* 251 */     if (this.hp.getKeys()[38] != 0) {
/* 252 */       this.human.move(Direction.UP);
/*     */     }
/* 254 */     if (this.hp.getKeys()[40] != 0) {
/* 255 */       this.human.move(Direction.DOWN);
/*     */     }
/* 257 */     if (this.hp.getKeys()[37] != 0) {
/* 258 */       this.human.move(Direction.LEFT);
/*     */     }
/* 260 */     if (this.hp.getKeys()[39] != 0) {
/* 261 */       this.human.move(Direction.RIGHT);
/*     */     }
/*     */   }
/*     */   
/*     */   public void loseGame() {
/* 266 */     this.lost = true;
/* 267 */     if (this.hp != null) {
/* 268 */       this.hp.showMessage("LOST");
/*     */     }
/*     */   }
/*     */   
/*     */   public void winGame() {
/* 273 */     this.won = true;
/* 274 */     if (this.hp != null) {
/* 275 */       this.hp.showMessage("WON");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasLost()
/*     */   {
/* 284 */     return this.lost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasWon()
/*     */   {
/* 292 */     return this.won;
/*     */   }
/*     */   
/*     */   public int getSpeed() {
/* 296 */     return this.happerWalker.getDelay();
/*     */   }
/*     */ }


/* Location:              C:\Users\Isma_\Downloads\JHapper.jar!\jhapper\Game.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */