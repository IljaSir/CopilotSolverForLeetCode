class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        
        d = {0: -1}
        ans = 0
        count = 0
        for i, num in enumerate(nums):
            if num == 1:
                count += 1
            else:
                count -= 1
            if count in d:
                ans = max(ans, i - d[count])
            else:
                d[count] = i
        return ans