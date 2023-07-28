class Solution:
    def specialArray(self, nums: List[int]) -> int:
        
        for i in range(1, 1001):
            if len([x for x in nums if x >= i]) == i:
                return i
        return -1