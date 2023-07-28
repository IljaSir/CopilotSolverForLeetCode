class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        ans = 0
        for i in range(n-2):
            for j in range(i+1, n-1):
                for k in range(j+1, n):
                    if nums[i] + nums[j] > nums[k]:
                        ans += 1
                    else:
                        break
        return ans