class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        
        
        nums.sort()
        n = len(nums)
        res = [0] * n
        for i in range(n):
            if i % 2 == 0:
                res[i] = nums[i // 2]
            else:
                res[i] = nums[n - 1 - (i - 1) // 2]
        return res