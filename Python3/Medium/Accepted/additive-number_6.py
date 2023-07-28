class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        n = len(num)
        def dfs(i, j, k):
            if i >= n or j >= n or k >= n:
                return False
            if num[i] == '0' and j-i > 1:
                return False
            if num[j] == '0' and k-j > 1:
                return False
            x = int(num[i:j])
            y = int(num[j:k])
            z = str(x+y)
            if num[k:].startswith(z):
                if k+len(z) == n:
                    return True
                else:
                    return dfs(j, k, k+len(z))
            else:
                return False
        for j in range(1, n//2+1):
            for k in range(j+1, n):
                if dfs(0, j, k):
                    return True
        return False