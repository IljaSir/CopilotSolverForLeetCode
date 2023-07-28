class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        
        def get_permutation(n, k):
            if n == 1:
                return '1'
            else:
                fact = 1
                for i in range(2, n):
                    fact *= i
                first = (k-1) // fact
                k = (k-1) % fact + 1
                return str(first+1) + get_permutation(n-1, k)

        return get_permutation(n, k)