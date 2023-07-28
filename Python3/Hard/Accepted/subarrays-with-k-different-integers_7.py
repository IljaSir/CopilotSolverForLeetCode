class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        
        def helper(k):
            d = collections.Counter()
            res = i = 0
            for j, v in enumerate(nums):
                if d[v] == 0:
                    k -= 1
                d[v] += 1
                while k < 0:
                    d[nums[i]] -= 1
                    if d[nums[i]] == 0:
                        k += 1
                    i += 1
                res += j - i + 1
            return res
        return helper(k) - helper(k - 1)