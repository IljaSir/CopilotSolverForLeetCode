class Solution:
    def rotatedDigits(self, n: int) -> int:
        
        def isGood(x):
            s = str(x)
            if '3' in s or '4' in s or '7' in s:
                return False
            if '2' in s or '5' in s or '6' in s or '9' in s:
                return True
            return False
        
        return sum([isGood(x) for x in range(1, n+1)])