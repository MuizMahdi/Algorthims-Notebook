# Sliding Window Pattern
The sliding window pattern is used to solve sub-array (or sub-lists) problems, in which we need to perform some calculation
or an action among all or some of the sub-arrays of a given size.

#### [Pattern explanation video](https://www.youtube.com/watch?v=GcW4mgmgSbw)

![Sliding Window](resources/SlidingWindow_01.png "Sliding Window")

In some cases, the size of the sliding window is not fixed, and it needs to be expanded or shrank based on the problem
constraints, giving us two variants of sliding windows:
## 1. Fixed-sized sliding windows 
Useful for finding contiguous sub-array of length K that matches a condition.

### Examples of Use Cases
- Finding the average of all contiguous sub-arrays of length K in an array.
- Finding the sum of each sub-array of length K in an array.

**Contiguous**: In sequence | Sharing a common border | Next to each other.

### Steps
1. Establish the size of the window.
2. Set both window start and end at i=0.
3. Loop through the elements of the array.
4. Slide the window by moving the window end pointer.
5. Do whatever we want with the current window's elements.
6. Slide the window by moving the window start pointer.

## 2. Dynamically-sized sliding windows 
Useful for finding the **largest** or **smallest** contiguous sub-array that matches some sort of condition.

### Examples of Use Cases
- Finding the smallest sub-array of a given sum

### Steps
1. Set both window start and end at i=0.
2. Slide and keep moving the end pointer until our requirement is reached.
3. Do whatever we want with the current window's elements.
4. Slide the window by moving the window start pointer, as long as requirement is not reached.
5. Slide the end pointer until requirement is reached, and repeat.

<br>

## Pattern Templates
#### 1. Fixed Sized Sliding Window (averages of sub-arrays of size k)
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

#### 2. Dynamically Sized Sliding Window ()
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
class DynamicallySlidingWindow() {

    double[] minSubArrayLengthForSum(int s, int[] arr) {
        /* 
        [Initialize window reminder and result/output] 
        */
        // Initialize window sum and minimum length
        int sum = 0, minLength = Integer.MAX_VALUE;

        /*
         [Loop through array elements, moving the end of the window]
         */
        int start = 0;
        for (int end = 0; end < arr.length; end++) {

            /*
             [Include end item in our current window reminder]
             */
            // Add element at the end to the window sum
            sum += arr[end];

            /*
             Once [sub-array requirement is fulfilled], and along (that's when window starts sliding)
             */
            // Once current window sum is equal or greater than the given sum, and along
            while (sum >= s) {

                /*
                 [Do whatever we want with the current window according to requirement] 
                 */
                // Compare current window length and min window length
                int currentWindowLength = end - start + 1; // +1 cuz we start from 0, and we want length to start from 1
                minWindowLength = Math.min(minWindowLength, currentWindowLength);

                /*
                 [Exclude the element at the start from our window reminder]
                 */
                // Subtract element at the start from the window sum
                sum -= arr[start];

                /*
                 [Slide the window by moving the start pointer] (end pointer moved via loop)
                 */
                start++;

            }
        }

        // [Return result/output]
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    
}
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
class SlidingWindow() {
    
    double[] findAverages(int k, int[] arr) {
        int numOfWindows = arr.length - k + 1;
        double[] results = new double[numOfWindows];
        for (int i = 0; i <= arr.length - k; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            result[i] = sum / k;
        }
        return results;
    }
    
}
```

<br>

### Neetcode + Blind/Grind 75 + Company Specific
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

#### Google - Medium
- 3Sum
- 

### [More Sliding Window Problems (73)](https://leetcode.com/tag/sliding-window/)
