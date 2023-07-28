class Solution:
    def sumSubseqWidths(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        p = [1]
        for i in range(1, n):
            p.append(p[-1]*2 % (10**9 + 7))
        s = 0
        for i in range(n):
            s += (nums[i] - nums[n-1-i]) * (p[i] - p[n-1-i])
        return s % (10**9 + 7)