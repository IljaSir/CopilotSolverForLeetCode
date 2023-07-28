class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        if len(nums) < 2:
            return False
        if k == 0:
            return any(nums[i] == 0 and nums[i+1] == 0 for i in range(len(nums)-1))
        if k < 0:
            k = -k
        d = {0:-1}
        s = 0
        for i, n in enumerate(nums):
            s += n
            s %= k
            if s in d:
                if i - d[s] > 1:
                    return True
            else:
                d[s] = i
        return False