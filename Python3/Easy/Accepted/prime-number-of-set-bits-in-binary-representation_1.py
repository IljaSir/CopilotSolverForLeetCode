class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        
        
        def isPrime(num):
            if num == 1:
                return False
            for i in range(2, int(num ** 0.5) + 1):
                if num % i == 0:
                    return False
            return True
        
        count = 0
        for i in range(left, right + 1):
            if isPrime(bin(i).count('1')):
                count += 1
        return count