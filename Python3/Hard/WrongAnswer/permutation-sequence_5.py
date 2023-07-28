class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        
        def factorial(n):
            if n == 0:
                return 1
            return n * factorial(n - 1)

        def get_permutation(n, k):
            if n == 1:
                return [1]
            if k == 0:
                return list(range(1, n + 1))
            if k == factorial(n - 1):
                return list(range(n, 0, -1))
            if k < factorial(n - 1):
                return [n] + get_permutation(n - 1, k)
            return [n - k // factorial(n - 1)] + get_permutation(n - 1, k % factorial(n - 1))

        return ''.join(map(str, get_permutation(n, k - 1)))