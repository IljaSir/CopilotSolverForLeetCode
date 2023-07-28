class Solution:
    def closestDivisors(self, num: int) -> List[int]:
        
        a, b = num + 1, num + 2
        for i in range(int(a**0.5), 0, -1):
            if a % i == 0:
                return [i, a // i]
        for i in range(int(b**0.5), 0, -1):
            if b % i == 0:
                return [i, b // i]