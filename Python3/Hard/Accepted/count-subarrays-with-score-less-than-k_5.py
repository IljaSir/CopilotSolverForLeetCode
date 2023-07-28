class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        
        # sliding window
        # O(n)
        n = len(nums)
        res = 0
        i = 0
        j = 0
        s = 0
        while j < n:
            s += nums[j]
            while i <= j and s * (j - i + 1) >= k:
                s -= nums[i]
                i += 1
            res += j - i + 1
            j += 1
        return res