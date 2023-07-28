class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        
        res = 0
        miss = 1
        i = 0
        while miss <= n:
            if i < len(nums) and nums[i] <= miss:
                miss += nums[i]
                i += 1
            else:
                miss += miss
                res += 1
        return res