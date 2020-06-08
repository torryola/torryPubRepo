import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Method_Referencing
{
    private List<String> list = new ArrayList<>();
    private Supplier<ArrayList> supplier = ArrayList::new;

    public static void main (String[] args)
    {
        String str = "abc";
        String str2 = "abc_What";
        // Lambda style
        Predicate<String> predStr = s -> s.startsWith(str);
        // Anonymous class Style
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s)
            {
                return s.startsWith(str);
            }
        };

        if (predicate.test(str2)) //(str2.startsWith(str))
        {
            Consumer<String> preString = System.out::println;
            preString.accept(str2);
        } else
            System.out.println("Doesn't start with "+str);
    }



}//End Class
