package Pack;

import java.util.*;


public class Dimension {
    private static final Map<Integer, String> pow = new HashMap<>();
    private static  Map<String, Integer> measure = new HashMap<>();
    private String[] str = new String[2];
    private int mainPow;
    private String dimension;

    static {
        pow.put(-18, "атто");
        pow.put(-15, "фемто");
        pow.put(-12, "пико");
        pow.put(-9, "нано");
        pow.put(-6, "микро");
        pow.put(-3, "мили");
        pow.put(-2, "санти");
        pow.put(-1, "деци");
        pow.put(1, "дека");
        pow.put(2, "гекто");
        pow.put(3, "кило");
        pow.put(6, "мега");
        pow.put(9, "гига");
        pow.put(12, "тера");
        pow.put(15, "пета");
        pow.put(18, "экса");

    }

    public class Pair<K,V> {

        private final K element0;
        private final V element1;


        public Pair(K element0, V element1) {
            this.element0 = element0;
            this.element1 = element1;
        }

        public K getElement0() {
            return element0;
        }

        public V getElement1() {
            return element1;
        }

    }
    public Dimension (String dimension) {
        this.dimension = dimension;
        valueOf(dimension);
    }

    public Pair<Map<String , Integer>, Integer> valueOf (String dimension) {
        Pair<Map<String , Integer> , Integer> pair = null;
        mainPow = 0;
        dimension = dimension.replace(" ", "");
        String upperPart = dimension.split("\\/")[0];
        List<String> splittedUpperPart = Arrays.asList(upperPart.split("\\*"));
        partsHandler(splittedUpperPart, 1);
        if (dimension.split("\\/").length > 1) {
            String lowerPart = dimension.split("\\/")[1];
            List<String> splittedLowerPart = Arrays.asList(lowerPart.split("\\*"));
            partsHandler(splittedLowerPart, -1);
        }
        return pair = new Pair(measure, mainPow);  //вернуть measure и mainPow в Pair

    }
    private void partsHandler(List<String> splittedPart, int key) {
        for (String str : splittedPart) {
            List<String> splittedSplittedPart = new ArrayList<>();
            boolean isSplitted = false;
            for (int i : pow.keySet()) {
                if (str.startsWith(pow.get(i))) {
                    splittedSplittedPart = Arrays.asList(str.split(pow.get(i),2));
                }
                if (splittedSplittedPart.size() > 1) {
                    List<String> splittedSplittedSplittedPart = Arrays.asList(splittedSplittedPart.get(1).split("\\^"));
                    int pow = 1;
                    if (splittedSplittedSplittedPart.size() > 1) {
                        pow = Integer.parseInt(splittedSplittedSplittedPart.get(1));
                    }
                    mainPow = mainPow + key * i * pow;
                    if (!measure.keySet().contains(splittedSplittedSplittedPart.get(0))) {
                        measure.put(splittedSplittedSplittedPart.get(0), key * pow);
                    } else {
                        measure.replace(splittedSplittedSplittedPart.get(0), measure.get(splittedSplittedSplittedPart.get(0)) + key * pow);
                    }
                    isSplitted = true;
                    break;
                }
            }
            if (!isSplitted) {
                List<String> splittedSplittedSplittedPart = Arrays.asList(str.split("\\^"));
                int pow = 1;
                if (splittedSplittedSplittedPart.size() > 1) {
                    pow = Integer.parseInt(splittedSplittedSplittedPart.get(1));
                }
                if (!measure.keySet().contains(splittedSplittedSplittedPart.get(0))) {
                    measure.put(splittedSplittedSplittedPart.get(0), key * pow);
                } else {
                    measure.replace(splittedSplittedSplittedPart.get(0), measure.get(splittedSplittedSplittedPart.get(0)) + key * pow);
                }
            }
        }
    }

    @Override
    public String toString () {
        List<String> strings = new ArrayList<>();
        strings.addAll(measure.keySet());
        Map<String, Integer> Map = new HashMap<>();
        for (String str : strings) {
            Map.put(str , measure.get(str));
        }
        String out = "";
        for (String m : Map.keySet()) {
            if (Map.get(m) != 0 && Map.get(m) != 1)
                out = out + m + "^" + Map.get(m) + " * ";
            if (Map.get(m) == 1)
                out = out + m + " * ";
            if (Map.get(m) == 0)
                out = "";
        }
        if (out.length() > 2) {
            out = out.substring(0, out.length() - 2);
        }
        measure.clear();
        Map.clear();
        return out;
    }


    public String[] getDimenstion() {
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof String && str[0].equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
