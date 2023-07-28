class Solution:
    def findLHS(self, nums: List[int]) -> int:
        d = {}
        for num in nums:
            if num in d:
                d[num] += 1
            else:
                d[num] = 1
        max_len = 0
        for key in d:
            if key + 1 in d:
                max_len = max(max_len, d[key] + d[key + 1])
        return max_len