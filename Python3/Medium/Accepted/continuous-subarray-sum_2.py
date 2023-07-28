class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        if k == 0:
            for i in range(1, len(nums)):
                if nums[i] == 0 and nums[i-1] == 0:
                    return True
            return False
        s = 0
        seen = {0: -1}
        for i, n in enumerate(nums):
            s += n
            s %= k
            if s in seen:
                if i - seen[s] > 1:
                    return True
            else:
                seen[s] = i
        return False