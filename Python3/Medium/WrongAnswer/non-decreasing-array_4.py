class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        
        if len(nums) == 1:
            return True
        if nums[0] > nums[1]:
            nums[0] = nums[1]
        cnt = 0
        for i in range(1, len(nums)-1):
            if nums[i] > nums[i+1]:
                cnt += 1
                if nums[i-1] > nums[i+1]:
                    nums[i+1] = nums[i]
                else:
                    nums[i] = nums[i+1]
        return cnt <= 1