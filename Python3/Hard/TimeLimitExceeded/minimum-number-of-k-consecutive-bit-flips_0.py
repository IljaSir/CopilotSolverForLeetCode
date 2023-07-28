class Solution:
    def minKBitFlips(self, nums: List[int], k: int) -> int:
        
        res = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                if i + k > len(nums):
                    return -1
                for j in range(i, i + k):
                    nums[j] = 1 - nums[j]
                res += 1
        return res