# Prefix Sum Algorithm
The prefix sum algorithm, also known as the cumulative sum or prefix sum, is a technique used to efficiently compute 
the cumulative sum of elements in an array, where each element in the resulting array is the sum of all elements in 
the original array up to a certain position. The prefix sum array allows for quick retrieval of cumulative sums for 
various sub-arrays.

Also Used when we're doing some calculation on an array, where we want to save computation or memory by storing the 
computation for the previous indexes in a prefix array. Sort of like building a hashmap which returns the result 
of an array elements computation instantly, without any recalculation.

### Patters:
- Do *something* for all elements in array except element at index i
- Do *something* for all elements in array until element at index i
  - We store values of doing the *something* for all previous elements until element at index i in prefix array.


### [Pattern explanation video](https://www.youtube.com/watch?v=7pJo_rM0z_s)

![Prefix Sum](resources/prefix_sum.png "Prefix Sum")

---

### Applications
- **Efficient range sum queries**: With the prefix sum array, you can calculate the sum of elements in a specific 
sub-array efficiently. To find the sum of elements between positions start and end in arr, you can simply subtract 
prefix[start-1] from prefix[end], i.e., prefix[end] - prefix[start-1]. If start is 0, you don't need to subtract 
prefix[start-1].
- **Efficient average calculations**: You can use the prefix sum array to compute the average of elements in any 
sub-array by using the method described above and dividing by the number of elements in the subarray. 
- **Efficient updates**: If you need to update a single element in the original array, you can update the corresponding 
element in the prefix sum array as well. This allows you to maintain the cumulative sum efficiently when there are 
updates.

### Steps
1. TODO

---

## Pattern Templates
TODO
```java
/**
 * Time complexity: O(n)
 *      Where n = number of elements in the array.
 * Approach:
 *      Let k = window size, arrLength = array length 
 *      1. Get number of windows => (arrLength - k + 1)
 *      2. Create results array with length of => (numOfWindows)
 *      3. Loop through all array elements
 *          3.1. Add the element at the end
 *          3.2. Once the end of the first window is reached and from that point and on => (i >= k - 1):
 *              3.2.1. Do whatever we want with the window
 *              3.2.2. Subtract element from at the start
 *              3.2.3. Slide the window by moving the start pointer, since end pointer is already moved via loop              
 */
class FixedSlidingWindow() {
    
    double[] findAverages(int k, int[] arr) {
        int numOfWindows = arr.length - k + 1;
        double[] results = new double[numOfWindows];
        double sum = 0;

        int start = 0;
        // Loop through arr elements, moving the end of the window
        for (int end = 0; end < arr.length; end++) {

            // Add element at the end
            sum += arr[end];

            // Once we reach, and starting from the end of first window and along (that's when window starts sliding)
            int firstWindowEndIdx = k - 1;
            if (end >= firstWindowEndIdx) {

                // Get average and add it to results list
                double avg = sum / k;
                results[start] = avg;

                // Subtrack the element at the start
                sum -= arr[start];

                // Slide the window by moving the start pointer (end pointer moved via loop)
                start++;

            }
        }

        return results;
    }
    
}
```

<br>

### Neetcode + Blind 75 + Grokking Problems
#### Easy
- [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

#### Medium
- [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
- [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- [Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)
- [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)
- [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)
- [Permutation in String](https://leetcode.com/problems/permutation-in-string/)
- [Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
- [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
- [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)

#### Hard
- [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)
- [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
- [Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)

### [More Sliding Window Problems (73)](https://leetcode.com/tag/sliding-window/)
