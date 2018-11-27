/*     */ package jhapper;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.io.PrintStream;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HapperPanel
/*     */   extends JPanel
/*     */   implements KeyListener
/*     */ {
/*     */   private Game game;
/*  19 */   boolean[] pressedKeys = new boolean['ƒ'];
/*     */   
/*     */   public HapperPanel(Game game) {
/*  22 */     this.game = game;
/*  23 */     setLayout(null);
/*  24 */     int hpWidth = game.getPositions().length * 30 + 5;
/*  25 */     int hpHeight = game.getPositions().length * 30 + 5;
/*  26 */     setMinimumSize(new Dimension(hpWidth, hpHeight));
/*  27 */     setPreferredSize(getMinimumSize());
/*  28 */     addKeyListener(this);
/*  29 */     setFocusable(true);
/*     */   }
/*     */   
/*     */   public void paintComponent(Graphics g)
/*     */   {
/*  34 */     super.paintComponent(g);
/*  35 */     drawPlayField(g);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void drawPlayField(Graphics g)
/*     */   {
/*  43 */     if (this.game == null) {
/*  44 */       System.out.println("no game available");
/*  45 */       return;
/*     */     }
/*  47 */     Position[][] positions = this.game.getPositions();
/*  48 */     if (positions == null)
/*  49 */       return;
/*  50 */     for (int col = 0; col < positions.length; col++) {
/*  51 */       for (int row = 0; row < positions[col].length; row++) {
/*  52 */         g.setColor(Color.RED);
/*  53 */         g.drawRect(col * 30, row * 30, 30, 30);
/*  54 */         drawGameObjects(g, positions[col][row]);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void drawGameObjects(Graphics g, Position pos)
/*     */   {
/*  65 */     if ((pos != null) && 
/*  66 */       (pos.getGameObject() != null)) {
/*  67 */       pos.getGameObject().paintComponent(g, this);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void keyTyped(KeyEvent e) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void keyPressed(KeyEvent e)
/*     */   {
/*  83 */     resetKeys();
/*  84 */     this.pressedKeys[e.getKeyCode()] = true;
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/*  88 */     resetKeys();
/*  89 */     this.pressedKeys[e.getKeyCode()] = false;
/*     */   }
/*     */   
/*     */   public void showMessage(String msg) {
/*  93 */     this.game.stopGame();
/*  94 */     int ans = JOptionPane.showConfirmDialog(this, msg + "\nWould you like to replay the game?", "YOU " + msg, 0);
/*  95 */     if (ans == 0) {
/*  96 */       this.game.resetGame();
/*  97 */       this.game.startGame();
/*     */     }
/*     */   }
/*     */   
/*     */   public void resizeField(int sliderValue) {
/* 102 */     this.game.setDimension(sliderValue);
/* 103 */     this.game.resetGame();
/* 104 */     int hpWidth = this.game.getPositions().length * 30 + 5;
/* 105 */     int hpHeight = this.game.getPositions().length * 30 + 5;
/* 106 */     setMinimumSize(new Dimension(hpWidth, hpHeight));
/* 107 */     setPreferredSize(getMinimumSize());
/* 108 */     setSize(getMinimumSize());
/* 109 */     Main.mainApplication.pack();
/* 110 */     Main.mainApplication.setLocationRelativeTo(null);
/*     */   }
/*     */   
/*     */   private void resetKeys() {
/* 114 */     for (boolean key : this.pressedKeys) {
/* 115 */       key = false;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean[] getKeys() {
/* 120 */     return this.pressedKeys;
/*     */   }
/*     */ }


/* Location:              C:\Users\Isma_\Downloads\JHapper.jar!\jhapper\HapperPanel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */