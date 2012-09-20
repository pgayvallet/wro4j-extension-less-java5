/*
 * Copyright (C) 2011.
 * All rights reserved.
 */
package ro.isdc.wro.extensions.processor.js;

import ro.isdc.wro.extensions.processor.support.linter.AbstractLinter;
import ro.isdc.wro.extensions.processor.support.linter.JsHint;
import ro.isdc.wro.model.resource.ResourceType;
import ro.isdc.wro.model.resource.SupportedResourceType;


/**
 * Processor which analyze the js code and warns you about any problems. The processing result won't change no matter
 * if the processed script contains errors or not.
 *
 * @author Alex Objelean
 * @since 1.3.5
 * @created 1 Mar 2011
 */
@SupportedResourceType(ResourceType.JS)
public class JsHintProcessor
  extends AbstractLinterProcessor {
  public static final String ALIAS = "jsHint";
  /**
   * {@inheritDoc}
   */
  @Override
  protected AbstractLinter newLinter() {
    return new JsHint();
  }
}