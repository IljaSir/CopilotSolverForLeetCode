class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        if k == 0:
            return any(nums[i] == nums[i+1] == 0 for i in range(len(nums)-1))
        if k < 0:
            k = -k
        d = {}
        d[0] = -1
        s = 0
        for i, n in enumerate(nums):
            s += n
            if s % k in d:
                if i - d[s % k] > 1:
                    return True
            else:
                d[s % k] = i
        return False