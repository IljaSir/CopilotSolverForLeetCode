class Solution:
    def jump(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 1:
            return 0
        step = 0
        max_pos = 0
        end = 0
        for i in range(n-1):
            max_pos = max(max_pos, i+nums[i])
            if i == end:
                step += 1
                end = max_pos
        return step