class Solution:
    def countSpecialNumbers(self, n: int) -> int:
        
        def isSpecial(n):
            s = set()
            while n:
                if n % 10 in s:
                    return False
                s.add(n % 10)
                n //= 10
            return True
        return sum(isSpecial(i) for i in range(1, n+1))