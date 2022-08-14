# Sliding Window Pattern
The sliding window pattern is used to solve sub-array (or sub-lists) problems, in which we need to perform some calculation
or processing among all or some of the sub-arrays of a given size.

[Pattern explanation video](https://www.youtube.com/watch?v=GcW4mgmgSbw)

### Examples
- Finding the average of all contiguous sub-arrays of length K in an array.
- Finding the sum of each sub-array of length K in an array.

**Contiguous**: In sequence | Sharing a common border | Next to each other.

### Steps
1. Establish the size of the window.
2. Compute the result for the 1st window (from the start of the data structure).
3. Use a loop to slide the window by 1, and keep computing the result for each window.

<br>

### Pattern Template
```java


```

<br>

### Brute Force Alternative
```java
/**
 * Time complexity: O(n*k)
 *      Where n = number of elements in the array.
 *            k = window size / sub-array length.
 * Approach:
 *      Let k = window size, arrLength = array length 
 *      1. Get number of windows:
 *          arrLength - k + 1
 *      2. Create results array with length of:
 *          number of windows
 *      3. Loop through array elements until:
 *          arrLength - k (last element before window overflows)
 *      4. Loop through window, starting from element i, until:
 *          i + k (last element in current window)
 */
double[] findAverages(int k, int[] arr) {
    int numOfWindows = arr.length - k + 1;
    double[] result = new double[numOfWindows];
    for (int i = 0; i <= arr.length - k; i++) {
        double sum = 0;
        for (int j = i; j < i + k; j++) {
            sum += arr[j];
        }
        result[i] = sum / k;
    }
    return result;
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
