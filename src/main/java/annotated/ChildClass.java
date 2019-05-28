package annotated;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.validation.constraints.NotNull;

public class ChildClass extends MiddleClass {

	@NotNull
	public String getId() {
		return "";
	};

	public static void main(String[] args) {
		Method[] ann = ChildClass.class.getDeclaredMethods();
		for (Method m : ann) {
			Annotation[] at = ((AnnotatedElement) m).getAnnotations();
			System.out.println("Method " + ((AnnotatedElement) m) + " has annotations: " + Arrays.toString(at));
		}
	}
}
