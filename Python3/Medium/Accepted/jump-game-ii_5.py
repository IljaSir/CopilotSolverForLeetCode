class Solution:
    def jump(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 1:
            return 0
        jumps = [0] * n
        for i in range(n-2, -1, -1):
            if i + nums[i] >= n-1:
                jumps[i] = 1
            else:
                min_jumps = float('inf')
                for j in range(1, nums[i]+1):
                    if min_jumps > jumps[i+j]:
                        min_jumps = jumps[i+j]
                jumps[i] = min_jumps + 1
        return jumps[0]