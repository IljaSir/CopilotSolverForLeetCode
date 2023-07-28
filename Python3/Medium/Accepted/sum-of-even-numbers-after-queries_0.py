class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        
        ans = []
        sum = 0
        for n in nums:
            if n % 2 == 0:
                sum += n
        for q in queries:
            if nums[q[1]] % 2 == 0:
                sum -= nums[q[1]]
            nums[q[1]] += q[0]
            if nums[q[1]] % 2 == 0:
                sum += nums[q[1]]
            ans.append(sum)
        return ans