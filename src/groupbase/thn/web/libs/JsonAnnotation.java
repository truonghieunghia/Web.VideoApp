package groupbase.thn.web.libs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by nghiath on 4/3/15.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAnnotation {

	public String FieldName() default "";

	public Class<?> FieldType() default Object.class;

	public String[] PathRoot() default "";

	public boolean isObject() default false;

	public boolean isList() default false;
	public boolean isEncode() default false;
}
