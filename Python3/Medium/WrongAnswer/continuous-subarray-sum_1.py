class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        if len(nums) < 2:
            return False
        if k == 0:
            for i in range(1, len(nums)):
                if nums[i] == nums[i-1] == 0:
                    return True
            return False
        if k < 0:
            k = -k
        s = set()
        s.add(0)
        n = len(nums)
        s1 = 0
        for i in range(n):
            s1 += nums[i]
            s1 %= k
            if s1 in s:
                return True
            s.add(s1)
            s1 += nums[i]
            s1 %= k
        return False