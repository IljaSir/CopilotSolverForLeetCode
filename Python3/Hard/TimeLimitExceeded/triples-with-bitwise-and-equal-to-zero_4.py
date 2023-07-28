class Solution:
    def countTriplets(self, nums: List[int]) -> int:
        
        # O(N^2)
        # O(1)
        res = 0
        for i in range(len(nums)):
            for j in range(len(nums)):
                for k in range(len(nums)):
                    if nums[i] & nums[j] & nums[k] == 0:
                        res += 1
        return res