class Solution:
    def jump(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n <= 1:
            return 0
        step = 0
        cur_max = 0
        cur_rch = 0
        for i in range(n):
            if cur_rch < i:
                step += 1
                cur_rch = cur_max
            cur_max = max(cur_max, nums[i] + i)
        return step