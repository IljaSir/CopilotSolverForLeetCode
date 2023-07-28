class Solution:
    def findLHS(self, nums: List[int]) -> int:
        d = {}
        for num in nums:
            d[num] = d.get(num, 0) + 1
        max_length = 0
        for key in d:
            if key + 1 in d:
                max_length = max(max_length, d[key] + d[key + 1])
        return max_length