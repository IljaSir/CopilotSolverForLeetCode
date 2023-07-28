class Solution:
    def countDistinct(self, nums: List[int], k: int, p: int) -> int:
        
        # O(n^2) time complexity
        # O(n) space complexity
        mod = [0] * p
        mod[0] = 1
        prefix_sum = 0
        res = 0
        for i, num in enumerate(nums):
            prefix_sum += num
            prefix_sum %= p
            mod[prefix_sum] += 1
            for j in range(p):
                if mod[j] > k:
                    mod[j] -= 1
                else:
                    res += mod[j]
        return res