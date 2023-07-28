class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        
        def isPrime(num):
            if num < 2:
                return False
            for i in range(2, int(math.sqrt(num)) + 1):
                if num % i == 0:
                    return False
            return True
        count = 0
        for num in range(left, right + 1):
            if isPrime(bin(num).count('1')):
                count += 1
        return count