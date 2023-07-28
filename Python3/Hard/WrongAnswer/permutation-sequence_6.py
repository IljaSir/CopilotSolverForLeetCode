class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        
        import math
        def get_kth(n, k):
            if n == 1:
                return '1'
            if n == 2:
                if k == 1:
                    return '12'
                else:
                    return '21'
            if n == 3:
                if k == 1:
                    return '123'
                elif k == 2:
                    return '132'
                elif k == 3:
                    return '213'
                elif k == 4:
                    return '231'
                elif k == 5:
                    return '312'
                else:
                    return '321'
            if k <= math.factorial(n-1):
                return str(n) + get_kth(n-1, k)
            else:
                return get_kth(n-1, k-math.factorial(n-1)) + str(n)
        return get_kth(n, k)