import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity O(N) & Space Complexity O(N)
 */
public class FirstDuplicate {
    public static void main(String[] st) {
        int[] nums = new int[]{2, 5, 4, 6, 9, 3, 8, 9, 7, 1};
        System.out.println(firstDuplicateWithSet(nums));
        System.out.println(firstDuplicateWithSort(nums));
        System.out.println(firstDuplicateWithFloydCycleDetection(nums));
    }

    private static int firstDuplicateWithFloydCycleDetection(int[] nums) {
        // Find the intersection point of the two runners.
        int t = nums[0];
        int h = nums[0];
        do {
            t = nums[t];
            h = nums[nums[h]];
        } while (t != h);

        // Find the "entrance" to the cycle.
        t = nums[0];
        while(t != h) {
            t = nums[t];
            h = nums[h];
        }
        return h;
    }

    private static int firstDuplicateWithSort(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }

    private static int firstDuplicateWithSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
}
