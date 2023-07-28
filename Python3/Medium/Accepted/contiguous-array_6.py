class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        
        d = {0:-1}
        m = 0
        count = 0
        for i, num in enumerate(nums):
            if num == 0:
                count -= 1
            else:
                count += 1
            if count in d:
                m = max(m, i - d[count])
            else:
                d[count] = i
        return m