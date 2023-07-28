class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        
        n = len(nums)
        maxn = float('-inf')
        r = -1
        for i in range(n):
            if nums[i] < maxn:
                r = i
            else:
                maxn = nums[i]
        
        minn = float('inf')
        l = -1
        for i in range(n-1, -1, -1):
            if nums[i] > minn:
                l = i
            else:
                minn = nums[i]
        
        if r == -1:
            return 0
        else:
            return r - l + 1