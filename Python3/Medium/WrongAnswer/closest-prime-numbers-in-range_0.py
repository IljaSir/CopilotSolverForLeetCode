class Solution:
    def closestPrimes(self, left: int, right: int) -> List[int]:
        
        def isPrime(n):
            if n <= 1:
                return False
            if n <= 3:
                return True
            if n % 2 == 0 or n % 3 == 0:
                return False
            i = 5
            while i * i <= n:
                if n % i == 0 or n % (i + 2) == 0:
                    return False
                i += 6
            return True
        def closestPrimes(left: int, right: int) -> List[int]:
            if right - left <= 1:
                return [-1, -1]
            if left <= 2:
                return [2, 3]
            min_diff = right - left
            ans = [-1, -1]
            for i in range(left + 1, right):
                if isPrime(i):
                    if i - left <= min_diff:
                        min_diff = i - left
                        ans = [left, i]
                    if right - i <= min_diff:
                        min_diff = right - i
                        ans = [i, right]
                    if min_diff == 2:
                        return ans
                    left = i
            return ans
        return closestPrimes(left, right)