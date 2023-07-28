class Solution:
    def validPartition(self, nums: List[int]) -> bool:
        
        n = len(nums)
        if n < 3:
            return False
        i, j = 0, 1
        while j < n:
            if nums[j] == nums[i]:
                j += 1
            else:
                if j - i >= 2:
                    return True
                i = j
                j += 1
        if j - i >= 2:
            return True
        return False