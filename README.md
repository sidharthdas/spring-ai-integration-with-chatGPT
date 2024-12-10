

# Spring AI

Need to generate the token and add it to application.properties file
``` spring.ai.openai.apikey=```

# Check if any model has annotation, if yes, then verify it 

```
public class MainClass {

    public static void main(String[] args) throws IllegalAccessException {

        TestSidharthModel testSidharthModel = new TestSidharthModel("helloSidha5rth");
        System.out.println(testSidharthModel);
        System.out.println(error(testSidharthModel));
        System.out.println(testSidharthModel);

    }

    private static Set<String> error(Object obj) throws IllegalAccessException {
        Set<String> set = new HashSet<>();
        if (obj != null) {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for(Field f : fields) {
                f.setAccessible(true);
                if(f.isAnnotationPresent(CheckSidharthPresent.class)) {
                    CheckSidharthPresent c = f.getAnnotation(CheckSidharthPresent.class);
                    String s = (String) f.get(obj);
                    if(!s.contains("Sidharth")) {
                        set.add(c.message());
                        f.set(obj, "SidharthDas");
                    }
                }
            }
        }
        return set;
    }
}
```
