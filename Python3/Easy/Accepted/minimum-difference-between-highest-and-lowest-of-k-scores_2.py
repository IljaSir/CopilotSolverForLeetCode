class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        ans = 10**5
        for i in range(len(nums)-k+1):
            ans = min(ans, nums[i+k-1]-nums[i])
        return ans