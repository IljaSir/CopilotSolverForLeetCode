class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        
        n = len(nums)
        ans = 0
        for i in range(n):
            if nums[i] != -1:
                cnt = 0
                j = i
                while nums[j] != -1:
                    cnt += 1
                    t = nums[j]
                    nums[j] = -1
                    j = t
                ans = max(ans, cnt)
        return ans