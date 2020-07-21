import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Interview Question: The Two­Sum ProblemDifficulty: MediumThis is a classic algorithmic interview question.
 * There are many different solution routes,each of which involves a different technique.
 * This handout details the problem and gives a few different solution routes.
 * Problem Statement:You are given an array of n integers and a number k. Determine whether there is a pairof
 * elements in the array that sums to exactly k.
 * For example, given the array [1, 3, 7] andk = 8, the answer is “yes,” but given k = 6 the answer is “no.”
 *
 * Possible Follow­Up Questions:
 * Can you modify the array? Yes, that's fine.
 * Do we know something about the range of the numbers in the array? No, they canbe arbitrary integers.
 * Are the array elements necessarily positive? No, they can be positive, negative,or zero.
 * Do we know anything about the value of k relative to n or the numbers in the ar­ray? No, it can be arbitrary.
 * Can we consider pairs of an element and itself?  No, the pair should consist oftwo different array elements.
 * Can the array contain duplicates? Sure, that's a possibility.
 * Is the array necessarily in sorted order? No, that's not guaranteed.
 * What about integer overflow? For simplicity, don't worry about this.
 *
 * What to Watch For
 * Make sure their solution works on arrays of zero or one element (it should alwaysreturn false.)
 * Make sure their solution always returns a value.
 * Make sure their solution works with both positive and negative numbers.
 * Make sure their solution works if the only way to make the sum is to use an ele­ment that appears twice in the array (for example, [3, 3] with k=6 )
 * Make sure their solution works if the answer is “no” but k/2 is present in the array(for example, [1, 3] with k = 6) should return false.
 *
 * Golden rule -
 * Brute Force O(n^2) - Stand Solution
 * Alternative -
 * Add DataStructure like Map & Set to reduce to single iteration which adds Space Comp
 * Work on Pointers or Indexes to reduce iterations without Space Comp
 * Sort Array to simplified solution
 */
public class TwoSum {

    public static void main(String[] st) {
        int[] nums = new int[]{1,3,4,5,2, 5}; // 1, 2, 3, 4, 5, 5
        int k = 10;
        System.out.println(sumOfTwoHash(nums, k)); // It will not work for duplicate
        System.out.println(sumOfTwoSort(nums, k));
    }

    /**
     * Time - O(n)
     * Space - O(n)
     */
    private static boolean sumOfTwoHash(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            int diff = k - i;
            return set.contains(diff);
        }
        return false;
    }

    /**
     * Time - O(n)
     * Space - O(n)
     */
    private static boolean sumOfTwoSort(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i =0; i < nums.length; i++) {
            int siblingIndex = Arrays.binarySearch(nums, 0, nums.length, (k - nums[i]));
            if(siblingIndex >= 0) {
                if(siblingIndex != i
                        || (i > 0 && nums[i-1] == nums[i])
                        || (i < nums.length -1 && nums[i+1] == nums[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
