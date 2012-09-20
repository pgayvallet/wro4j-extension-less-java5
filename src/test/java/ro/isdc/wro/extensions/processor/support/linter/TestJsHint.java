/**
 * Copyright Alex Objelean
 */
package ro.isdc.wro.extensions.processor.support.linter;

import org.junit.Test;


/**
 * @author Alex Objelean
 */
public class TestJsHint {
  private final JsHint jsHint = new JsHint();

  @Test
  public void testSetNullOptions()
    throws Exception {
    final String options = null;
    jsHint.setOptions(options);
    jsHint.validate("");
  }


  @Test
  public void shouldValidateWithNoOptions()
    throws Exception {
    jsHint.validate("");
  }


  @Test
  public void shouldValidateWithMultipleOptions()
    throws Exception {
    jsHint.setOptions("undef,eqeqeq");
    jsHint.validate("");
  }


  @Test(expected = LinterException.class)
  public void shouldNotAcceptBadOptions()
    throws Exception {
    jsHint.setOptions("1,2");
    jsHint.validate("");
  }


  @Test(expected = LinterException.class)
  public void shouldValidateInvalidScript()
    throws Exception {
    jsHint.validate("al ert(1)");
  }


  @Test
  public void shouldValidateValidScript()
    throws Exception {
    jsHint.validate("$(function(){})(jQuery);");
  }


  @Test(expected = LinterException.class)
  public void shouldValidateWithUndefOption()
    throws Exception {
    jsHint.setOptions("undef");
    jsHint.validate("$(function(){})(jQuery);");
  }


  @Test(expected = LinterException.class)
  public void shouldValidateWithEqeqeqOption()
    throws Exception {
    jsHint.setOptions("eqeqeq");
    jsHint.validate("var j = 1;var i = j == 0 ? j + 1 : j - 1;");
  }

  @Test(expected = LinterException.class)
  public void shouldValidateWithEqeqOption2()
    throws Exception {
    jsHint.setOptions("eqeqeq");
    jsHint.validate("if (text == 0) {win.location.href = link; }");
  }
  
  @Test(expected=LinterException.class)
  public void shouldFailWhenIndentationIsNotCorrect()
    throws Exception {
    jsHint.setOptions("indent=2,white");
    jsHint.validate("function test() {\n     alert(1);\n}");
  }
  
  @Test
  public void shouldNotFailWhenIndentationIsCorrect()
    throws Exception {
    jsHint.setOptions("indent=2,white");
    jsHint.validate("function test() {\n  alert(1);\n}");
  }
}
