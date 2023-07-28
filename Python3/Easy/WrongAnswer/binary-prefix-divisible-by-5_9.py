class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        
        # # 1st solution: 40 ms (97%) and 14.3 MB (100%)
        # result = []
        # current = 0
        # for num in nums:
        #     current = (current * 2 + num) % 5
        #     result.append(current == 0)
        # return result
        # 2nd solution: 32 ms (99%) and 14.1 MB (100%)
        return [((2 * current + num) % 5 == 0) for num, current in zip(nums, accumulate(nums, lambda x, y: (2 * x + y) % 5))]