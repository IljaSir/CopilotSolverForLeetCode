class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        
        nums = set(nums)
        ans = 0
        for i in range(1, 2*10**5+1):
            if all(i%j!=0 for j in nums):
                continue
            else:
                ans += 1
        return ans