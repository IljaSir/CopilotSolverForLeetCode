class Solution:
    def specialArray(self, nums: List[int]) -> int:
        
        nums.sort()
        for i in range(1, len(nums)+1):
            if nums[-i] < i:
                return i if i == 1 or nums[-i-1] >= i else -1
        return -1