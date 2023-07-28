class Solution:
    def jump(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 1: return 0
        max_reach = nums[0]
        jumps = 1
        end = nums[0]
        for i in range(1, n):
            if i == n - 1: return jumps
            max_reach = max(max_reach, i + nums[i])
            if i == end:
                jumps += 1
                end = max_reach