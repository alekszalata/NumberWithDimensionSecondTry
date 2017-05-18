package Pack;

import javafx.util.Pair;

import java.util.*;


public class Dimension {
    private String dimension;
    private static final Map<Integer, String> pow = new HashMap<>();
    private static Map<String, Integer> measure = new HashMap<>();
    private static int mainPow;
    String out;


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


    public static Map<String, Integer> partsHandler(List<String> splittedUpperPart, int key) {
        for (String str : splittedUpperPart) {
            List<String> splittedSplittedUpperPart = new ArrayList<>();
            boolean isSplitted = false;
            for (int i : pow.keySet()) {
                splittedSplittedUpperPart = Arrays.asList(str.split(pow.get(i),2));
                if (splittedSplittedUpperPart.size() > 1) {
                    List<String> splittedSplittedSplittedUpperPart = Arrays.asList(splittedSplittedUpperPart.get(1).split("\\^"));
                    int pow = 1;
                    if (splittedSplittedSplittedUpperPart.size() > 1) {
                        pow = Integer.parseInt(splittedSplittedSplittedUpperPart.get(1));
                    }
                    mainPow = mainPow + key * i * pow;
                    if (!measure.keySet().contains(splittedSplittedSplittedUpperPart.get(0))) {
                        measure.put(splittedSplittedSplittedUpperPart.get(0), key * pow);
                    } else {
                        measure.replace(splittedSplittedSplittedUpperPart.get(0), measure.get(splittedSplittedSplittedUpperPart.get(0)) + key * pow);
                    }
                    isSplitted = true;
                    break;
                }
            }
            if (!isSplitted) {
                List<String> splittedSplittedSplittedUpperPart = Arrays.asList(str.split("\\^"));
                int pow = 1;
                if (splittedSplittedSplittedUpperPart.size() > 1) {
                    pow = Integer.parseInt(splittedSplittedSplittedUpperPart.get(1));
                }
                if (!measure.keySet().contains(splittedSplittedSplittedUpperPart.get(0))) {
                    measure.put(splittedSplittedSplittedUpperPart.get(0), key * pow);
                } else {
                    measure.replace(splittedSplittedSplittedUpperPart.get(0), measure.get(splittedSplittedSplittedUpperPart.get(0)) + key * pow);
                }
            }
        }
        return measure;
    }

    public static String[] Normalise(String dimension) {
        dimension = dimension.replace(" ", "");
        String upperPart = dimension.split("/")[0];
        List<String> splittedUpperPart = Arrays.asList(upperPart.split("\\*"));
        measure = partsHandler(splittedUpperPart, 1);

        if (dimension.split("/").length > 1) {
            String lowerPart = dimension.split("/")[1];
            List<String> splittedLowerPart = Arrays.asList(lowerPart.split("\\*"));
        measure = partsHandler(splittedLowerPart, -1);
        }
        List<String> strings = new ArrayList<>();
        strings.addAll(measure.keySet());
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



