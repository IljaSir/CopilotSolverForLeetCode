class Solution:
    def getXORSum(self, arr1: List[int], arr2: List[int]) -> int:
        
        return reduce(lambda x, y: x ^ y, arr1) & reduce(lambda x, y: x ^ y, arr2)