class Solution:
    def jump(self, nums: List[int]) -> int:
        
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 1:
            return 0
        ans = 0
        cur = 0
        next = 0
        for i in range(n):
            next = max(next, i + nums[i])
            if i == cur:
                ans += 1
                cur = next
            if cur >= n - 1:
                return ans
        return ans