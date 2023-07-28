class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        
        res = 0
        for i in range(len(nums)):
            if nums[i] >= 0:
                count = 0
                while nums[i] >= 0:
                    count += 1
                    tmp = nums[i]
                    nums[i] = -1
                    i = tmp
                res = max(res, count)
        return res