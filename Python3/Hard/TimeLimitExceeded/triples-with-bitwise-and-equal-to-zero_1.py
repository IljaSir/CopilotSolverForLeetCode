class Solution:
    def countTriplets(self, nums: List[int]) -> int:
        
        res, n = 0, len(nums)
        for i in range(n):
            for j in range(n):
                for k in range(n):
                    if nums[i] & nums[j] & nums[k] == 0:
                        res += 1
        return res