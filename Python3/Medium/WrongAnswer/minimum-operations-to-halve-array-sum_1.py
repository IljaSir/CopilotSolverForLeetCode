class Solution:
    def halveArray(self, nums: List[int]) -> int:
        
        # nums.sort()
        # s = sum(nums)
        # n = len(nums)
        # for i in range(n):
        #     s -= nums[i]
        #     if s < sum(nums) / 2:
        #         return i + 1
        # return n
        nums.sort(reverse=True)
        s = sum(nums)
        n = len(nums)
        for i in range(n):
            s -= nums[i]
            if s < sum(nums) / 2:
                return i + 1
        return n