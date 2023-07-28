class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        
        queries = [(q, i) for i, q in enumerate(queries)]
        queries.sort()
        nums.sort()
        ans = [0] * len(queries)
        i, j = 0, 0
        while i < len(queries):
            q, qidx = queries[i]
            while j < len(nums) and nums[j] <= q:
                j += 1
            ans[qidx] = j
            i += 1
        return ans