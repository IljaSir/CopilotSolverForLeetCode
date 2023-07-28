class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        N = len(nums)
        if N < 3:
            return 0
        diff = nums[1] - nums[0]
        count = 0
        ans = 0
        for i in range(2, N):
            if nums[i] - nums[i-1] == diff:
                count += 1
            else:
                diff = nums[i] - nums[i-1]
                count = 0
            ans += count
        return ans