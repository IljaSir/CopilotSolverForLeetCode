class Solution:
    def jump(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 1:
            return 0
        if nums[0] >= n-1:
            return 1
        if nums[0] == 0:
            return -1
        maxReach = nums[0]
        steps = nums[0]
        jumps = 1
        for i in range(1, n):
            if i == n-1:
                return jumps
            maxReach = max(maxReach, i+nums[i])
            steps -= 1
            if steps == 0:
                jumps += 1
                if i >= maxReach:
                    return -1
                steps = maxReach - i
        return -1