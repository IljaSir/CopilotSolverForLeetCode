class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        
        n = len(nums)
        if n <= 1:
            return True
        count = 0
        for i in range(1, n):
            if nums[i] < nums[i-1]:
                count += 1
                if i-2 >= 0 and nums[i] < nums[i-2]:
                    nums[i] = nums[i-1]
                else:
                    nums[i-1] = nums[i]
            if count > 1:
                return False
        return True