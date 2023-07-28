class Solution:
    def unequalTriplets(self, nums: List[int]) -> int:
        
        n = len(nums)
        nums.sort()
        result = 0
        for i in range(n):
            for j in range(i+1, n):
                for k in range(j+1, n):
                    if nums[i] == nums[j] or nums[j] == nums[k] or nums[i] == nums[k]:
                        continue
                    result += 1
        return result