class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n < 3:
            return 0
        count = 0
        for i in range(n):
            if i == 0:
                if nums[i] != nums[i+1]:
                    count += 1
            elif i == n-1:
                if nums[i] != nums[i-1]:
                    count += 1
            else:
                if nums[i] != nums[i-1] and nums[i] != nums[i+1]:
                    count += 1
        return count