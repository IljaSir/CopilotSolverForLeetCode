class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        n = len(num)
        def helper(i, j, k):
            if k == n:
                return True
            x, y = int(num[i:j+1]), int(num[j+1:k+1])
            if x > y:
                return False
            z = str(x+y)
            if num[k+1:].startswith(z):
                return helper(j+1, k+1, k+len(z))
            return False
        for i in range(n//2):
            for j in range(i+1, n-1):
                if helper(0, i, j):
                    return True
        return False