class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        
        count = 0
        max_length = 0
        d = {0:-1}
        for i in range(len(nums)):
            if nums[i] == 1:
                count += 1
            else:
                count -= 1
            if count in d:
                max_length = max(max_length, i - d[count])
            else:
                d[count] = i
        return max_length