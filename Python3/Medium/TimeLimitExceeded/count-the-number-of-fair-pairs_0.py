class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        
        n = len(nums)
        ans = 0
        for i in range(n):
            for j in range(i+1, n):
                if lower <= nums[i] + nums[j] <= upper:
                    ans += 1
        return ans