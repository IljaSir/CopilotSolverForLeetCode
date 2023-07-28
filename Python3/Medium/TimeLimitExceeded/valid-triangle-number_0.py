class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        result = 0
        for i in range(n-2):
            for j in range(i+1, n-1):
                for k in range(j+1, n):
                    if nums[i] + nums[j] > nums[k]:
                        result += 1
        return result