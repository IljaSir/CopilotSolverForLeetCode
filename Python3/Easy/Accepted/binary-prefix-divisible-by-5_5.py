class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        
        n = len(nums)
        ans = [False] * n
        val = 0
        for i in range(n):
            val = (val << 1) + nums[i]
            ans[i] = val % 5 == 0
        return ans