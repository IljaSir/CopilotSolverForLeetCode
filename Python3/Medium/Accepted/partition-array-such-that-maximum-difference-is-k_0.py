class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        i, j = 0, 1
        n = len(nums)
        res = 1
        while j < n:
            if nums[j] - nums[i] > k:
                res += 1
                i = j
            j += 1
        return res