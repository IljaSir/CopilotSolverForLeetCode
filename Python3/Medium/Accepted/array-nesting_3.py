class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        
        n = len(nums)
        ans = 0
        for i in range(n):
            count = 0
            while nums[i] != -1:
                nums[i], i = -1, nums[i]
                count += 1
            ans = max(ans, count)
        return ans