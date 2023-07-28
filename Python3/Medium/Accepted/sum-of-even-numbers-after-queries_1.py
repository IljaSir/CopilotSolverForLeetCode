class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        
        res = []
        sum = 0
        for i in range(len(nums)):
            if nums[i] % 2 == 0:
                sum += nums[i]
        for i in range(len(queries)):
            if nums[queries[i][1]] % 2 == 0:
                sum -= nums[queries[i][1]]
            nums[queries[i][1]] += queries[i][0]
            if nums[queries[i][1]] % 2 == 0:
                sum += nums[queries[i][1]]
            res.append(sum)
        return res