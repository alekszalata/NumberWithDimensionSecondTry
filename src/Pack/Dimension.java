package Pack;

import javafx.util.Pair;

import java.util.*;


public class Dimension {
    private static final Map<Integer, String> pow = new HashMap<>();
    private static Map<String, Integer> measure = new HashMap<>();
    private static final List<String> operations = new ArrayList<>();

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

        operations.add("\\*");
        operations.add("\\/");
        operations.add("\\^");
    }

     public static String[] Normalise(String dimension) {
         int mainPow = 0;
         dimension = dimension.replace(" ","");
         String upperPart = dimension.split(operations.get(1))[0];
         List<String> splittedUpperPart = Arrays.asList(upperPart.split(operations.get(0)));
         for (String str : splittedUpperPart) {
             List<String> splittedSplittedUpperPart = new ArrayList<>();
             boolean isSplitted = false;
             for (int i : pow.keySet()) {
                 splittedSplittedUpperPart = Arrays.asList(str.split(pow.get(i)));
                 if (splittedSplittedUpperPart.size() > 1) {
                     List<String> splittedSplittedSplittedUpperPart = Arrays.asList(splittedSplittedUpperPart.get(1).split(operations.get(2)));
                     int pow = 1;
                     if (splittedSplittedSplittedUpperPart.size() > 1) {
                         pow = Integer.parseInt(splittedSplittedSplittedUpperPart.get(1));
                     }
                     mainPow = mainPow + i * pow;
                     if (!measure.keySet().contains(splittedSplittedSplittedUpperPart.get(0))) {
                        measure.put(splittedSplittedSplittedUpperPart.get(0), pow);
                     } else {
                         measure.replace(splittedSplittedSplittedUpperPart.get(0), measure.get(splittedSplittedSplittedUpperPart.get(0)) + pow);
                     }
                     isSplitted = true;
                     break;
                 }
             }
             if(!isSplitted) {
                 List<String> splittedSplittedSplittedUpperPart = Arrays.asList(str.split(operations.get(2)));
                 int pow = 1;
                 if (splittedSplittedSplittedUpperPart.size() > 1) {
                     pow = Integer.parseInt(splittedSplittedSplittedUpperPart.get(1));
                 }
                 if (!measure.keySet().contains(splittedSplittedSplittedUpperPart.get(0))) {
                     measure.put(splittedSplittedSplittedUpperPart.get(0), pow);
                 } else {
                     measure.replace(splittedSplittedSplittedUpperPart.get(0), measure.get(splittedSplittedSplittedUpperPart.get(0)) + pow);
                 }
             }
         }
         if (dimension.split(operations.get(1)).length > 1) {
             String lowerPart = dimension.split(operations.get(1))[1];
             List<String> splittedLowerPart = Arrays.asList(lowerPart.split(operations.get(0)));
             for (String str : splittedLowerPart) {
                 List<String> splittedSplittedLowerPart = new ArrayList<>();
                 boolean isSplitted = false;
                 for (int i : pow.keySet()) {
                     splittedSplittedLowerPart = Arrays.asList(str.split(pow.get(i)));
                     if (splittedSplittedLowerPart.size() > 1) {
                         List<String> splittedSplittedSplittedLowerPart = Arrays.asList(splittedSplittedLowerPart.get(1).split(operations.get(2)));
                         int pow = 1;
                         if (splittedSplittedSplittedLowerPart.size() > 1) {
                             pow = Integer.parseInt(splittedSplittedSplittedLowerPart.get(1));
                         }
                         mainPow = mainPow - i * pow;
                         if (!measure.keySet().contains(splittedSplittedSplittedLowerPart.get(0))) {
                             measure.put(splittedSplittedSplittedLowerPart.get(0), -pow);
                         } else {
                             measure.replace(splittedSplittedSplittedLowerPart.get(0), measure.get(splittedSplittedSplittedLowerPart.get(0)) - pow);
                         }
                         isSplitted = true;
                         break;
                     }
                 }
                 if (!isSplitted) {
                     List<String> splittedSplittedSplittedLowerPart = Arrays.asList(str.split(operations.get(2)));
                     int pow = 1;
                     if (splittedSplittedSplittedLowerPart.size() > 1) {
                         pow = Integer.parseInt(splittedSplittedSplittedLowerPart.get(1));
                     }
                     if (!measure.keySet().contains(splittedSplittedSplittedLowerPart.get(0))) {
                         measure.put(splittedSplittedSplittedLowerPart.get(0), -pow);
                     } else {
                         measure.replace(splittedSplittedSplittedLowerPart.get(0), measure.get(splittedSplittedSplittedLowerPart.get(0)) - pow);
                     }
                 }
             }
         }
         List<String> strings = new ArrayList<>();
         strings.addAll(measure.keySet());
         strings.sort(new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
                 return o1.compareTo(o2);
             }
         });
         Map<String, Integer> Map = new HashMap<>();
         for (String str : strings) {
             Map.put(str, measure.get(str));
         }
         String out = "";
         for (String m : Map.keySet()) {
             if (Map.get(m) != 0 && Map.get(m) != 1)
                out = out + m + "^" + Map.get(m) + " * ";
             if (Map.get(m) == 1)
                 out = out + m + " * ";
         }
         out = out.substring(0, out.length() - 2);
         String[] str = {String.valueOf(mainPow), out};
         measure.clear();
         Map.clear();
         return str;
    }
}
