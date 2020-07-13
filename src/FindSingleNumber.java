import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class FindSingleNumber {

    public static void main(String[] st) {
        int[] nums = new int[]{2,2,3,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                int count = (Integer) countMap.get(num);
                countMap.put(num, count + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        Iterator hmIterator = countMap.entrySet().iterator();
        while(hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            if((Integer)mapElement.getValue() == 1) {
                return (Integer)mapElement.getKey();
            }
        }
        return -1;
    }
}
