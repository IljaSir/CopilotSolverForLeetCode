class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        
        res = 0
        for i in range(len(nums)):
            s = 0
            for j in range(i, len(nums)):
                s += nums[j]
                if s * (j-i+1) < k:
                    res += 1
                else:
                    break
        return res