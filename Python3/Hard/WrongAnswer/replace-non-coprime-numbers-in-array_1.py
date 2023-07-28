class Solution:
    def replaceNonCoprimes(self, nums: List[int]) -> List[int]:
        
        primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]
        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a
        def lcm(a, b):
            return a * b // gcd(a, b)
        def is_coprime(a, b):
            return gcd(a, b) == 1
        def get_min_prime_factor(n):
            for i in primes:
                if n % i == 0:
                    return i
            return n
        def get_min_prime_factor_list(n):
            res = []
            while n > 1:
                p = get_min_prime_factor(n)
                res.append(p)
                n //= p
            return res
        n = len(nums)
        min_prime_factors = [get_min_prime_factor_list(i) for i in nums]
        res = []
        for i in range(n):
            if i == n - 1:
                res.append(nums[i])
                break
            if is_coprime(nums[i], nums[i + 1]):
                res.append(nums[i])
            else:
                res.append(lcm(nums[i], nums[i + 1]))
                i += 1
        return res