class Solution:
    def countQuadruplets(self, nums: List[int]) -> int:
        
        n = len(nums)
        ans = 0
        for i in range(n-3):
            for j in range(i+1, n-2):
                for k in range(j+1, n-1):
                    for l in range(k+1, n):
                        if nums[i] < nums[k] < nums[j] < nums[l]:
                            ans += 1
        return ans