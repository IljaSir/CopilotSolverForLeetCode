class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        
        result = []
        for val, index in queries:
            nums[index] += val
            result.append(sum(filter(lambda x: x % 2 == 0, nums)))
        return result