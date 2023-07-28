class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        if len(nums) < 2:
            return False
        if k == 0:
            return any(nums[i] == 0 and nums[i + 1] == 0 for i in range(len(nums) - 1))
        if k < 0:
            k = -k
        for i in range(len(nums) - 1):
            if nums[i] % k == 0 and nums[i + 1] % k == 0:
                return True
        s = set()
        s.add(0)
        p = 0
        for i in range(len(nums)):
            p += nums[i]
            p %= k
            if p in s:
                return True
            s.add(p)
        return False