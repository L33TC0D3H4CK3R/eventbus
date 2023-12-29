package cn.hackforums.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The bus cache annotation is used to subscribe the field to the eventbus.
 * <p>
 * We use the {@code RententionPolicy.RUNTIME} retention policy to ensure that the annotation is available at runtime.
 * We use the {@code ElementType.FIELD} element type to ensure that the annotation can only be applied to fields.
 * </p>
 *
 * @author Creida
 * @since 1.0.0, 12/28/2023
 * @version 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BusCache {
}