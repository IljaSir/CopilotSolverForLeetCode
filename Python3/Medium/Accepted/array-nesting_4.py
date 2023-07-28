class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        
        visited = set()
        res = 0
        for i in range(len(nums)):
            if i not in visited:
                count = 0
                while i not in visited:
                    visited.add(i)
                    i = nums[i]
                    count += 1
                res = max(res, count)
        return res