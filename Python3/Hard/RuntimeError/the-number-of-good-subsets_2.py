class Solution:
    def numberOfGoodSubsets(self, nums: List[int]) -> int:
        
        def prime_factorization(n):
            res = []
            for i in range(2, int(n**0.5)+1):
                while n%i==0:
                    res.append(i)
                    n //= i
            if n>1:
                res.append(n)
            return res
        
        def gcd(a,b):
            if a<b:
                a,b = b,a
            while b:
                a,b = b,a%b
            return a
        
        def lcm(a,b):
            return a*b//gcd(a,b)
        
        def lcm_list(l):
            res = l[0]
            for i in range(1,len(l)):
                res = lcm(res, l[i])
            return res
        
        def is_prime(n):
            if n==1:
                return False
            for i in range(2, int(n**0.5)+1):
                if n%i==0:
                    return False
            return True
        
        def get_prime_factorization(n):
            res = []
            for i in range(2, int(n**0.5)+1):
                if n%i==0:
                    res.append(i)
                    while n%i==0:
                        n //= i
            if n>1:
                res.append(n)
            return res
        
        def get_prime_factorization_count(n):
            res = {}
            for i in range(2, int(n**0.5)+1):
                if n%i==0:
                    res[i] = 1
                    while n%i==0:
                        n //= i
            if n>1:
                res[n] = 1
            return res
        
        def get_prime_factorization_count_list(l):
            res = {}
            for n in l:
                for i in range(2, int(n**0.5)+1):
                    if n%i==0:
                        if i not in res:
                            res[i] = 1
                        else:
                            res[i] += 1
                        while n%i==0:
                            n //= i
                if n>1:
                    if n not in res:
                        res[n] = 1
                    else:
                        res[n] += 1
            return res
        
        def get_prime_factorization_count_list_2(l):
            res = {}
            for n in l:
                for i in range(2, int(n**0.5)+1):
                    if n%i