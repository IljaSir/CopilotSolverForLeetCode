class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        
        sum = 0
        for i in nums:
            if i % 2 == 0:
                sum += i
        result = []
        for i in range(len(queries)):
            if nums[queries[i][1]] % 2 == 0:
                sum -= nums[queries[i][1]]
            nums[queries[i][1]] += queries[i][0]
            if nums[queries[i][1]] % 2 == 0:
                sum += nums[queries[i][1]]
            result.append(sum)
        return result