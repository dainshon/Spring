package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface MyIncludeComponent {    //얘가 붙으면 component scan 에 포함

}
