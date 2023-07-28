class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        
        d = {}
        for i in nums:
            d[i] = d.get(i, 0) + 1
        for i in range(1, len(nums)+1):
            if i not in d:
                return [d[max(d.keys())], i]