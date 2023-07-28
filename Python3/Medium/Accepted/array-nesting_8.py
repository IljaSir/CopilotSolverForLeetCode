class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        
        n = len(nums)
        ans = 0
        for i in range(n):
            j = i
            cnt = 0
            while nums[j] != -1:
                cnt += 1
                k = nums[j]
                nums[j] = -1
                j = k
            ans = max(ans, cnt)
        return ans