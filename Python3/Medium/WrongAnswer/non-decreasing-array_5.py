class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        
        n = len(nums)
        if n <= 2:
            return True
        if nums[0] > nums[1]:
            nums[0] = nums[1]
        for i in range(1, n - 1):
            if nums[i] > nums[i + 1]:
                if nums[i - 1] <= nums[i + 1]:
                    nums[i] = nums[i - 1]
                else:
                    nums[i + 1] = nums[i]
        for i in range(n - 1):
            if nums[i] > nums[i + 1]:
                return False
        return True