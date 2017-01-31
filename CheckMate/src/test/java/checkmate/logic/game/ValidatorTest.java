/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkmate.logic.game;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llmlks
 */
public class ValidatorTest {
    
    Validator val;
    
    public ValidatorTest() {
    }
    
    @Before
    public void setUp() {
        val = new Validator(new ChessGame());
    }
}
