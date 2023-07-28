class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        
        def is_even(num):
            return num % 2 == 0
        def sum_even(nums):
            return sum([num for num in nums if is_even(num)])
        ans = []
        for query in queries:
            val = query[0]
            index = query[1]
            nums[index] += val
            ans.append(sum_even(nums))
        return ans