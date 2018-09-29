import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class MyClassTest {

    private final String stringA = "A";
    private final String methodName = "setMyStringPrivate";

    @Test
    public void setStringToAUsingProtected() {
        MyClass myClass = new MyClass();
        myClass.setMyStringProtected(stringA);
        assertEquals(stringA, myClass.getMyString());
    }

    @Test
    public void setStringToAUsingPrivate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        MyClass myClass = new MyClass();
        Method method = MyClass.class.getDeclaredMethod(methodName, String.class);
        method.setAccessible(true);
        method.invoke(myClass, stringA);

        assertEquals(stringA, myClass.getMyString());
    }

}