class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        
        # Solution 1 - 36 ms
        """
        primes = [2, 3, 5, 7, 11, 13, 17, 19]
        return sum(bin(i).count('1') in primes for i in range(left, right + 1))
        """
        # Solution 2 - 28 ms
        def is_prime(n):
            if n <= 1:
                return False
            for i in range(2, int(n ** 0.5) + 1):
                if n % i == 0:
                    return False
            return True

        ans = 0
        for i in range(left, right + 1):
            if is_prime(bin(i).count('1')):
                ans += 1
        return ans