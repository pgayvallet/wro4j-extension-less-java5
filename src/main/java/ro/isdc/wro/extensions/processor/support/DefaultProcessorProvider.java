package ro.isdc.wro.extensions.processor.support;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ro.isdc.wro.extensions.processor.css.LessCssProcessor;
import ro.isdc.wro.extensions.processor.js.BeautifyJsProcessor;
import ro.isdc.wro.extensions.processor.js.CoffeeScriptProcessor;
import ro.isdc.wro.extensions.processor.js.DustJsProcessor;
import ro.isdc.wro.extensions.processor.js.HandlebarsJsProcessor;
import ro.isdc.wro.extensions.processor.js.HoganJsProcessor;
import ro.isdc.wro.extensions.processor.js.JsHintProcessor;
import ro.isdc.wro.extensions.processor.js.JsLintProcessor;
import ro.isdc.wro.model.resource.processor.ResourcePostProcessor;
import ro.isdc.wro.model.resource.processor.ResourcePreProcessor;
import ro.isdc.wro.model.resource.processor.decorator.LazyProcessorDecorator;
import ro.isdc.wro.model.resource.processor.decorator.ProcessorDecorator;
import ro.isdc.wro.model.resource.processor.support.ProcessorProvider;
import ro.isdc.wro.util.LazyInitializer;

/**
 * The implementation which contributes with processors from core module.
 * 
 * @author Alex Objelean
 * @created 1 Jun 2012
 */
public class DefaultProcessorProvider
    implements ProcessorProvider {
  /**
   * {@inheritDoc}
   */
  public Map<String, ResourcePreProcessor> providePreProcessors() {
    return createMap();
  }
  
  /**
   * {@inheritDoc}
   */
  public Map<String, ResourcePostProcessor> providePostProcessors() {
    final Map<String, ResourcePostProcessor> resultMap = new HashMap<String, ResourcePostProcessor>();
    /**
     * Created to overcome the difference between {@link ResourcePreProcessor} and {@link ResourcePostProcessor}
     * interfaces which will be resolved in next major version.
     */
    final Map<String, ResourcePreProcessor> preProcessorsMap = createMap();
    for (Entry<String, ResourcePreProcessor> entry : preProcessorsMap.entrySet()) {
      resultMap.put(entry.getKey(), new ProcessorDecorator(entry.getValue()));
    }
    return resultMap;
  }
  
  /**
   * @return the map of pre processors.
   */
  private Map<String, ResourcePreProcessor> createMap() {
    final Map<String, ResourcePreProcessor> map = new HashMap<String, ResourcePreProcessor>();

    map.put(BeautifyJsProcessor.ALIAS_BEAUTIFY, new LazyProcessorDecorator(new LazyInitializer<ResourcePreProcessor>() {
      @Override
      protected ResourcePreProcessor initialize() {
        return new BeautifyJsProcessor();
      }
    }));
    map.put(LessCssProcessor.ALIAS, new LazyProcessorDecorator(new LazyInitializer<ResourcePreProcessor>() {
      @Override
      protected ResourcePreProcessor initialize() {
        return new LessCssProcessor();
      }
    }));
    map.put(CoffeeScriptProcessor.ALIAS, new LazyProcessorDecorator(new LazyInitializer<ResourcePreProcessor>() {
      @Override
      protected ResourcePreProcessor initialize() {
        return new CoffeeScriptProcessor();
      }
    }));
    map.put(JsHintProcessor.ALIAS, new LazyProcessorDecorator(new LazyInitializer<ResourcePreProcessor>() {
      @Override
      protected ResourcePreProcessor initialize() {
        return new JsHintProcessor();
      }
    }));
    map.put(JsLintProcessor.ALIAS, new LazyProcessorDecorator(new LazyInitializer<ResourcePreProcessor>() {
      @Override
      protected ResourcePreProcessor initialize() {
        return new JsLintProcessor();
      }
    }));
    map.put(DustJsProcessor.ALIAS, new LazyProcessorDecorator(new LazyInitializer<ResourcePreProcessor>() {
      @Override
      protected ResourcePreProcessor initialize() {
        return new DustJsProcessor();
      }
    }));
    map.put(HoganJsProcessor.ALIAS, new LazyProcessorDecorator(new LazyInitializer<ResourcePreProcessor>() {
      @Override
      protected ResourcePreProcessor initialize() {
        return new HoganJsProcessor();
      }
    }));
    map.put(HandlebarsJsProcessor.ALIAS, new LazyProcessorDecorator(new LazyInitializer<ResourcePreProcessor>() {
      @Override
      protected ResourcePreProcessor initialize() {
        return new HandlebarsJsProcessor();
      }
    }));
    return map;
  }
}
