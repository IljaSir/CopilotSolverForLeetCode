class Solution:
    def closestPrimes(self, left: int, right: int) -> List[int]:
        
        def isPrime(n):
            if n < 2:
                return False
            for i in range(2, int(sqrt(n)) + 1):
                if n % i == 0:
                    return False
            return True
        def findPrime(n):
            p1 = n
            p2 = n
            while True:
                if isPrime(p1):
                    return p1
                if isPrime(p2):
                    return p2
                p1 -= 1
                p2 += 1
        p1 = findPrime(left)
        p2 = findPrime(right)
        if p2 - p1 <= right - left:
            return [p1, p2]
        else:
            return [-1, -1]