/*    */ package jhapper;
/*    */ 
/*    */ import java.awt.FlowLayout;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Main
/*    */   extends JFrame
/*    */ {
/* 12 */   public static Main mainApplication = null;
/*    */   private Game game;
/*    */   private HapperPanel happerPanel;
/*    */   private MenuPanel menuPanel;
/*    */   
/*    */   public Main()
/*    */   {
/* 19 */     setLayout(new FlowLayout(1));
/*    */     
/* 21 */     this.game = new Game();
/* 22 */     this.happerPanel = new HapperPanel(this.game);
/* 23 */     this.game.setHapperPanel(this.happerPanel);
/* 24 */     this.menuPanel = new MenuPanel(this.game, this.happerPanel);
/*    */     
/* 26 */     add(this.happerPanel);
/* 27 */     add(this.menuPanel);
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 31 */     mainApplication = new Main();
/* 32 */     mainApplication.setDefaultCloseOperation(3);
/* 33 */     mainApplication.pack();
/* 34 */     mainApplication.setResizable(false);
/* 35 */     mainApplication.setLocationRelativeTo(null);
/* 36 */     mainApplication.setTitle("Happer");
/* 37 */     mainApplication.setVisible(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Isma_\Downloads\JHapper.jar!\jhapper\Main.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */