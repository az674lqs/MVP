package chanson.lib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import chanson.lib.view.IView;

/**
 * Created by Chanson on 2016/5/19.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface ViewClass {
    Class<? extends IView> value();
}
