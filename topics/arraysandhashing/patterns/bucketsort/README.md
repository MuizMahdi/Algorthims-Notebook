# Bucket Sort
The bucket sort involves dividing elements into different "buckets" or groups. It divides the input array into a number 
of "buckets," each representing a range of values.

![Bucket Sort](resources/bucket_sort.png "Bucket Sort")

### Process:
1. Create an array of empty buckets (or lists)
2. Iterate through the input array, placing each element into its corresponding bucket based on its value
3. Possibly, sort the elements within each bucket (often using another sorting algorithm)
4. Concatenate the sorted buckets to get the final sorted array

### [Pattern explanation video](https://www.youtube.com/watch?v=VuXbEb5ywrU)

---

### Applications
- Frequency counting and top K elements: 
  - Problems that ask to find the most frequent elements or top K frequent elements
- Range-based problems:
  - Problems involving elements within a specific range (LeetCode 220)
- Sorting problems with known value ranges:
  - When the problem constraints specify a limited range of values e.g. Sorting an array of integers where all elements 
  are in the range [0, 1000]
- String sorting based on certain criteria (frequent of chars for example)
- Time-based data structures (LeetCode 981)
- Maximum gap problems:
  - Finding the maximum difference between successive elements in a sorted version of an array (LeetCode 164)
- Duplicate detection:
  - Identifying duplicates within a certain range (LeetCode 442)
  - 
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
