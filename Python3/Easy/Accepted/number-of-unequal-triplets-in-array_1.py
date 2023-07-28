class Solution:
    def unequalTriplets(self, nums: List[int]) -> int:
        
        nums.sort()
        ans = 0
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                for k in range(j+1, len(nums)):
                    if nums[i] != nums[j] and nums[j] != nums[k] and nums[i] != nums[k]:
                        ans += 1
        return ans