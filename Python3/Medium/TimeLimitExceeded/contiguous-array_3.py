class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        
        n = len(nums)
        for i in range(n):
            if nums[i] == 0:
                nums[i] = -1
        ans = 0
        for i in range(n):
            sum = 0
            for j in range(i, n):
                sum += nums[j]
                if sum == 0:
                    ans = max(ans, j - i + 1)
        return ans