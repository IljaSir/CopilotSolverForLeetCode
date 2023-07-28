class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        
        if not nums:
            return []
        n = len(nums)
        res = [0] * n
        for i in range(n-2, -1, -1):
            for j in range(i+1, n):
                if nums[j] < nums[i]:
                    res[i] += 1
        return res