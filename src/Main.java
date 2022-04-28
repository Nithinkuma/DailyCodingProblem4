import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String  lines = br.readLine();
        String[] strings = lines.trim().split(" ");

        List<Integer> inputArray = new ArrayList<>();
        for (String str : strings) {
            inputArray.add(Integer.parseInt(str));
        }

        int number = firstMissingPositiveInteger(inputArray);
        System.out.println(number);
    }

    private static int firstMissingPositiveInteger(List<Integer> inputArray) {

        Collections.sort(inputArray);

        List<Integer> noDuplicatesList = removeDuplicates(inputArray);
        int number = noDuplicatesList.get(noDuplicatesList.size() - 1) + 1;

        if (!noDuplicatesList.contains(1)) {
            number = 1;
        } else {
            for (int i = noDuplicatesList.indexOf(1); i < noDuplicatesList.size() - 1; ++i) {
                if (noDuplicatesList.get(i + 1) - noDuplicatesList.get(i) != 1) {
                    number = noDuplicatesList.get(i) + 1;
                    break;
                }
            }
        }
            return number;
    }

    private static List<Integer> removeDuplicates(List<Integer> inputArray) {
        Set<Integer> set = new LinkedHashSet<>(inputArray);
        inputArray.clear();
        inputArray.addAll(set);
        return inputArray;
    }
}