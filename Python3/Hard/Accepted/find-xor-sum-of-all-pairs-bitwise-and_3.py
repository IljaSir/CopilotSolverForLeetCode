class Solution:
    def getXORSum(self, arr1: List[int], arr2: List[int]) -> int:
        
        a = 0
        for x in arr1:
            a ^= x
        b = 0
        for y in arr2:
            b ^= y
        return a & b