
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

//new interface

public class TestClassToHash {

    public static class TestClass implements TestIface2 {
        @TestAnnotation(TestAnnotationEnum.VALUE)
        public int field;
        public TestDependency dependency;
        public final List<String> list;

        public TestClass() {
            // Non-signature dependency
            list = new ArrayList<String>();
        }

        @Override
        public TestEnum enumValue() {
            return TestEnum.VALUE;
        }
    }

    public static enum TestEnum {
        VALUE
    }

    public static enum TestAnnotationEnum {
        VALUE
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD })
    public @interface TestAnnotation {
        TestAnnotationEnum value();
    }

    public static class TestDependency {
        public int field;
    }

    public static interface TestIface2 {
        public TestEnum enumValue();
    }

}
