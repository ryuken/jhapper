/*     */ package jhapper;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JSlider;
/*     */ 
/*     */ public class MenuPanel extends javax.swing.JPanel implements ActionListener
/*     */ {
/*     */   private JButton startButton;
/*     */   private JButton stopButton;
/*     */   private JButton resetButton;
/*     */   private JButton jbSetSpeed;
/*     */   private JButton jbSetSize;
/*     */   private JLabel jlSpeedLabel;
/*     */   private JLabel jlSizeLabel;
/*     */   private JSlider jsSpeedSlider;
/*     */   private JSlider jsSizeSlider;
/*     */   private Game game;
/*     */   private HapperPanel hp;
/*     */   
/*     */   public MenuPanel(Game game, HapperPanel happerPanel)
/*     */   {
/*  25 */     this.game = game;
/*  26 */     this.hp = happerPanel;
/*  27 */     setLayout(new java.awt.GridLayout(10, 1, 2, 5));
/*  28 */     initComponents();
/*  29 */     add(new javax.swing.JToolBar.Separator());
/*  30 */     add(this.startButton);
/*  31 */     add(this.stopButton);
/*  32 */     add(this.resetButton);
/*  33 */     add(this.jlSpeedLabel);
/*  34 */     add(this.jsSpeedSlider);
/*  35 */     add(this.jbSetSpeed);
/*  36 */     add(this.jlSizeLabel);
/*  37 */     add(this.jsSizeSlider);
/*  38 */     add(this.jbSetSize);
/*     */     
/*  40 */     setSize(200, 300);
/*     */   }
/*     */   
/*     */   private void start() {
/*  44 */     enableButtons();
/*  45 */     this.startButton.setEnabled(false);
/*  46 */     setOptionsEnabled(false);
/*  47 */     this.hp.requestFocus();
/*  48 */     this.game.startGame();
/*     */   }
/*     */   
/*     */   private void stop() {
/*  52 */     enableButtons();
/*  53 */     this.stopButton.setEnabled(false);
/*  54 */     this.game.stopGame();
/*     */   }
/*     */   
/*     */   private void reset() {
/*  58 */     disableButtons();
/*  59 */     this.startButton.setEnabled(true);
/*  60 */     setOptionsEnabled(true);
/*  61 */     this.game.resetGame();
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/*  65 */     if (e.getSource() == this.startButton) {
/*  66 */       start();
/*  67 */     } else if (e.getSource() == this.stopButton) {
/*  68 */       stop();
/*  69 */     } else if (e.getSource() == this.resetButton) {
/*  70 */       reset();
/*  71 */     } else if (e.getSource() == this.jbSetSpeed) {
/*  72 */       int happerSpeed = this.jsSpeedSlider.getValue();
/*  73 */       this.hp.requestFocus();
/*  74 */       this.game.setHapperSpeed(1000 - happerSpeed);
/*  75 */     } else if (e.getSource() == this.jbSetSize) {
/*  76 */       int sliderValue = this.jsSizeSlider.getValue();
/*  77 */       this.hp.resizeField(sliderValue);
/*     */     }
/*     */   }
/*     */   
/*     */   private void initComponents() {
/*  82 */     this.startButton = new JButton("start");
/*  83 */     this.stopButton = new JButton("stop");
/*  84 */     this.resetButton = new JButton("reset");
/*     */     
/*  86 */     this.jbSetSpeed = new JButton("Set speed");
/*  87 */     this.jlSpeedLabel = new JLabel("Speed: ");
/*  88 */     this.jsSpeedSlider = new JSlider(1, 1000);
/*  89 */     this.jsSpeedSlider.setValue(1000 - this.game.getSpeed());
/*  90 */     this.jsSizeSlider = new JSlider(8, 20);
/*  91 */     this.jsSizeSlider.setValue(this.game.getPositions().length);
/*  92 */     this.jlSizeLabel = new JLabel("Playfield size: ");
/*  93 */     this.jbSetSize = new JButton("Set size: ");
/*     */     
/*  95 */     disableButtons();
/*     */     
/*  97 */     this.startButton.setEnabled(true);
/*     */     
/*  99 */     setOptionsEnabled(true);
/*     */     
/* 101 */     this.startButton.setEnabled(true);
/* 102 */     this.startButton.addActionListener(this);
/* 103 */     this.stopButton.addActionListener(this);
/* 104 */     this.resetButton.addActionListener(this);
/* 105 */     this.jbSetSpeed.addActionListener(this);
/* 106 */     this.jbSetSize.addActionListener(this);
/*     */   }
/*     */   
/*     */   private void enableButtons() {
/* 110 */     this.startButton.setEnabled(true);
/* 111 */     this.stopButton.setEnabled(true);
/* 112 */     this.resetButton.setEnabled(true);
/*     */   }
/*     */   
/*     */   private void disableButtons() {
/* 116 */     this.startButton.setEnabled(false);
/* 117 */     this.stopButton.setEnabled(false);
/* 118 */     this.resetButton.setEnabled(false);
/*     */   }
/*     */   
/*     */   private void setOptionsEnabled(boolean enabled) {
/* 122 */     this.jsSpeedSlider.setEnabled(enabled);
/* 123 */     this.jsSizeSlider.setEnabled(enabled);
/* 124 */     this.jbSetSpeed.setEnabled(enabled);
/* 125 */     this.jbSetSize.setEnabled(enabled);
/*     */   }
/*     */ }


/* Location:              C:\Users\Isma_\Downloads\JHapper.jar!\jhapper\MenuPanel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */