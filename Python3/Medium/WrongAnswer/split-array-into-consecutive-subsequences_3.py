class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        
        if len(nums) < 3:
            return False
        d = {}
        for i in nums:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        for i in range(len(nums)):
            if d[nums[i]] > 0:
                for j in range(2):
                    if nums[i]+j in d and d[nums[i]+j] > 0:
                        d[nums[i]+j] -= 1
                    else:
                        return False
        return True