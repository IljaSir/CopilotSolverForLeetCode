class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        
        nums.sort()
        n = len(nums)
        res = []
        for i in range(n//2):
            res.append(nums[i])
            res.append(nums[n//2+i])
        if n % 2 == 1:
            res.append(nums[-1])
        return res