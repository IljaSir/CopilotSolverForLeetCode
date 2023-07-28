class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        
        d = {}
        for i in nums:
            d[i] = d.get(i, 0) + 1
        for i in range(1, len(nums) + 1):
            if i not in d:
                return [d.get(i, 0), i]
            elif d.get(i, 0) == 2:
                return [i, i + 1]