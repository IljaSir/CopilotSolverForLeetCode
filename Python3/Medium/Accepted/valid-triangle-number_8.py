class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        res = 0
        for i in range(n):
            k = i
            for j in range(i+1, n):
                while k+1 < n and nums[k+1] < nums[i] + nums[j]:
                    k += 1
                res += max(k-j, 0)
        return res