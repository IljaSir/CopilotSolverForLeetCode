class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        
        result = []
        for val, index in queries:
            nums[index] += val
            result.append(sum([num for num in nums if num % 2 == 0]))
        return result