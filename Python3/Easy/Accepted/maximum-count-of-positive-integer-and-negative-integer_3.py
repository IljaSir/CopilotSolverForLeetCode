class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        
        # pos = 0
        # neg = 0
        # for num in nums:
        #     if num > 0:
        #         pos += 1
        #     elif num < 0:
        #         neg += 1
        # return max(pos, neg)
        # return max(len([num for num in nums if num > 0]), len([num for num in nums if num < 0]))
        return max(len(list(filter(lambda x: x > 0, nums))), len(list(filter(lambda x: x < 0, nums))))