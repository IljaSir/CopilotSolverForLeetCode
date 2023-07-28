class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        
        nums.sort()
        n = len(nums)
        best = 10**7
        for i in range(n):
            l = i+1
            r = n-1
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                if s > target:
                    r -= 1
                else:
                    l += 1
                if abs(s-target) < abs(best-target):
                    best = s
        return best