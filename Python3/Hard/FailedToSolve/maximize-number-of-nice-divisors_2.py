class Solution:
    def maxNiceDivisors(self, primeFactors: int) -> int:
        
        if primeFactors <= 3:
            return primeFactors
        if primeFactors % 3 == 0:
            return 3 ** (primeFactors // 3)
        if primeFactors % 3 == 1:
            return 3 ** (primeFactors // 3 - 1) * 4
        return 3 ** (primeFactors // 3) * 2