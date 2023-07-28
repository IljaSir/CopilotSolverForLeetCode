class Solution:
    def jump(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n < 2:
            return 0
        start, end, jumps = 0, nums[0], 1
        while end < n - 1:
            jumps += 1
            maxend = end + 1
            for i in range(start, end + 1):
                if i + nums[i] >= n - 1:
                    return jumps
                maxend = max(maxend, i + nums[i])
            start, end = end + 1, maxend
        return jumps