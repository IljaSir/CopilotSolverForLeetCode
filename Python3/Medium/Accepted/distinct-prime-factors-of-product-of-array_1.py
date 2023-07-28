class Solution:
    def distinctPrimeFactors(self, nums: List[int]) -> int:
        
        # 1st solution
        # O(nlogn) time | O(n) space
        # def find_prime_factors(num):
        #     prime_factors = set()
        #     while num % 2 == 0:
        #         prime_factors.add(2)
        #         num //= 2
        #     for i in range(3, int(num ** 0.5) + 1, 2):
        #         while num % i == 0:
        #             prime_factors.add(i)
        #             num //= i
        #     if num > 2:
        #         prime_factors.add(num)
        #     return prime_factors
        # prime_factors = set()
        # for num in nums:
        #     prime_factors |= find_prime_factors(num)
        # return len(prime_factors)
        # 2nd solution
        # O(nlogn) time | O(n) space
        prime_factors = set()
        for num in nums:
            for i in range(2, int(num ** 0.5) + 1):
                if num % i == 0:
                    prime_factors.add(i)
                    while num % i == 0:
                        num //= i
            if num > 1:
                prime_factors.add(num)
        return len(prime_factors)