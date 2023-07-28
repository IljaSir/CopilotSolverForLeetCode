class Solution:
    def getXORSum(self, arr1: List[int], arr2: List[int]) -> int:
        
        a = 0
        for i in arr1:
            a ^= i
        b = 0
        for i in arr2:
            b ^= i
        return a & b