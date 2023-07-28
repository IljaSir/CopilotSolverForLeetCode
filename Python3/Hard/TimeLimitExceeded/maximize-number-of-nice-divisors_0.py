class Solution:
    def maxNiceDivisors(self, primeFactors: int) -> int:
        
        if primeFactors == 1:
            return 1
        if primeFactors == 2:
            return 2
        if primeFactors == 3:
            return 3
        if primeFactors % 3 == 0:
            return 3 ** (primeFactors // 3) % (10 ** 9 + 7)
        if primeFactors % 3 == 1:
            return 4 * 3 ** (primeFactors // 3 - 1) % (10 ** 9 + 7)
        if primeFactors % 3 == 2:
            return 2 * 3 ** (primeFactors // 3) % (10 ** 9 + 7)