class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        
        n = len(nums)
        ans = 0
        for i in range(n):
            prod = 1
            for j in range(i, n):
                prod *= nums[j]
                if prod < k:
                    ans += 1
                else:
                    break
        return ans