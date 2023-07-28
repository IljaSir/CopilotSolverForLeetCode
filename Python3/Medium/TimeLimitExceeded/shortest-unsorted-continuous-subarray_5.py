class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        
        n = len(nums)
        l, r = n-1, 0
        for i in range(n-1):
            for j in range(i+1, n):
                if nums[i] > nums[j]:
                    l, r = min(l, i), max(r, j)
        return r-l+1 if r > l else 0