/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.ui;

import checkmate.logic.game.ChessGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llmlks
 */
public class ChessGUITest {
    
    ChessGUI gui;
    
    public ChessGUITest() {
    }
    
    @Before
    public void setUp() {
        gui = new ChessGUI();
    }
    
    @Test
    public void testChessNotNull() {
        assertTrue(gui.getChess() != null);
    }

    @Test
    public void testChessStarts() {
        assertTrue(gui.getChess().getPlayers().length == 2);
    }
    
    @Test
    public void testSquaresNotNull() {
        assertTrue(gui.getSquares() != null);
    }
    
    @Test
    public void testPiecesNotNull() {
        assertEquals(gui.getPieces().size(), 32);
    }
    
    @Test
    public void testSquarePanelsNotNull() {
        assertEquals(gui.getSquarePanels().length, new JPanel[8][8].length);
    }
    
    @Test
    public void testRunCreatesFrame() {
        gui.run();
        assertTrue(gui.getFrame() != null);
    }
    
    @Test
    public void testRunCreatesFrameWithRightName() {
        gui.run();
        assertTrue(gui.getFrame().getTitle().equals("CheckMate"));
    }
    
    @Test
    public void testRunSetsDefaultCloseOperation() {
        gui.run();
        assertTrue(gui.getFrame().getDefaultCloseOperation() == WindowConstants.EXIT_ON_CLOSE);
    }
    
    @Test
    public void testRunSetsPreferredSize() {
        gui.run();
        assertEquals(gui.getFrame().getPreferredSize(), gui.getSize());
    }
    
    @Test
    public void testCreateComponentsSetsLayout() {
        gui.run();
        assertEquals(gui.getFrame().getContentPane().getLayout().getClass(), new BorderLayout().getClass());
    }
    
    @Test
    public void testCreateComponentsCreatesGriPanel() {
        gui.run();
        assertFalse(gui.getGridPanel() == null);
    }
    
    @Test
    public void testCreateComponentsSetsGridPanelLayout() {
        gui.run();
        assertEquals(gui.getGridPanel().getLayout().getClass(), new GridLayout().getClass());
    }
}
