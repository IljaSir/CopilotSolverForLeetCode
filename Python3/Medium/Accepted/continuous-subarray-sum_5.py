class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        if len(nums) < 2:
            return False
        if k == 0:
            return False if len(nums) == 2 and nums[0] == 0 and nums[1] == 0 else True
        if k < 0:
            k = -k
        s = 0
        d = {0: -1}
        for i, n in enumerate(nums):
            s += n
            s %= k
            if s in d:
                if i - d[s] > 1:
                    return True
            else:
                d[s] = i
        return False