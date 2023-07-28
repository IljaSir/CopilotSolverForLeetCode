class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        
        # Solution 1 - Brute Force
        # Time  complexity: O(N^1/2)
        # Space complexity: O(1)
        # count = 0
        # for i in range(1, n+1):
        #     sum = 0
        #     for j in range(i, n+1):
        #         sum += j
        #         if sum == n:
        #             count += 1
        #             break
        #         elif sum > n:
        #             break
        # return count
        
        # Solution 2 - Math
        # Time  complexity: O(N^1/2)
        # Space complexity: O(1)
        count = 0
        for i in range(1, n+1):
            if (n - (i * (i-1) / 2)) / i > 0 and (n - (i * (i-1) / 2)) % i == 0:
                count += 1
        return count