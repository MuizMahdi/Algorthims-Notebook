# Kadane's Algorithm

Kadane's Algorithm is an efficient technique used to find the maximum sum contiguous subarray within a one-dimensional array of numbers. It's particularly useful for solving the "Maximum Subarray Problem" and can be applied to various related problems.

**In essence, it finds the largest sum of any contiguous subarray.**

The algorithm works by maintaining two variables: the current sum of the subarray being considered and the largest sum found so far. It iterates through the array once, updating these variables at each step.

### Patterns:
- Finding maximum (or minimum) sum subarray
- Solving problems related to contiguous sequences in arrays
- Optimizing dynamic programming solutions for certain array problems

### [Kadane's Algorithm Explanation Video](https://www.youtube.com/watch?v=86CQq3pKSUw)

![Kadane's Algorithm](https://example.com/kadanes_algorithm.png "Kadane's Algorithm")

---

### Applications
- **Maximum Subarray Sum**: Find the contiguous subarray with the largest sum
- **Stock Market Analysis**: Calculating maximum profit in a single buy-sell transaction
- **Image Processing**: Finding the brightest or darkest region in a 1D representation of an image
- **Time Series Analysis**: Identifying periods of maximum growth or decline
- **Signal Processing**: Detecting the strongest signal in a noisy environment
- **Dynamic Programming Optimization**: As a building block for more complex DP problems
- **Game Theory**: Solving certain types of game scenarios involving sequences

---

### Process
1. Initialize `largestSum` to the first element of the array and `currentSum` to 0
2. Iterate through each element in the array
3. At each step, reset `currentSum` to 0 if it becomes negative (using `Math.max(currentSum, 0)`)
4. Add the current element to `currentSum`
5. Update `largestSum` if `currentSum` is greater
6. After iterating through all elements, `largestSum` will contain the maximum subarray sum

## Template

```java
/**
 * Time complexity: O(n)
 *      Where n = number of elements in the array.
 * Space complexity: O(1)
 *      Only uses a constant amount of extra space.
 */
public class KadanesAlgorithm {
    public int maxSubArray(int[] nums) {
        int largestSum = nums[0];
        int currentSum = 0;
        
        for (int num : nums) {
            currentSum = Math.max(currentSum, 0);
            currentSum += num;
            largestSum = Math.max(largestSum, currentSum);
        }
        
        return largestSum;
    }
}
```

This implementation efficiently handles both positive and negative numbers. By resetting `currentSum` to 0 when it becomes negative, we ensure that we're always considering starting a new subarray at the current position if the previous sum would only decrease our total.

### Neetcode + Blind/Grind 75 + Company Specific
#### Easy
- [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

#### Medium
- [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)
- [Longest Turbulent Subarray](https://leetcode.com/problems/longest-turbulent-subarray/)
- [Maximum Sum Circular Subarray](https://leetcode.com/problems/maximum-sum-circular-subarray/)

#### Hard
- [Maximum Sum of 3 Non-Overlapping Subarrays](https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/)

### [More Dynamic Programming Problems (includes Kadane's variations)](https://leetcode.com/tag/dynamic-programming/)