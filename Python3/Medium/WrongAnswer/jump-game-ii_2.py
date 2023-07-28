class Solution:
    def jump(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 1:
            return 0
        if nums[0] >= n - 1:
            return 1
        if nums[0] == 0:
            return -1
        steps = 1
        i = 0
        while i < n - 1:
            max_i = i + 1
            for j in range(1, nums[i] + 1):
                if i + j >= n - 1:
                    return steps + 1
                if nums[i + j] + i + j > nums[max_i] + max_i:
                    max_i = i + j
            i = max_i
            steps += 1
        return -1