class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        ans = 0
        i = 0
        while i < n:
            j = i + 1
            while j < n and nums[j] <= 2 * nums[i]:
                j += 1
            ans = max(ans, j - i)
            i = j
        return ans