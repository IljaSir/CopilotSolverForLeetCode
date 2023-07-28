class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        
        if n < 1:
            return 0
        count = 0
        i = 0
        miss = 1
        while miss <= n:
            if i < len(nums) and nums[i] <= miss:
                miss += nums[i]
                i += 1
            else:
                miss += miss
                count += 1
        return count