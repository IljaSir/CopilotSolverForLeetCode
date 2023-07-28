class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        def dfs(i, j, k):
            if k == len(num):
                return True
            if num[i] == '0' and j - i > 1:
                return False
            if num[j] == '0' and k - j > 1:
                return False
            a, b = int(num[i:j]), int(num[j:k])
            c = a + b
            if str(c) != num[k:k + len(str(c))]:
                return False
            return dfs(j, k, k + len(str(c)))
        for i in range(1, len(num) - 1):
            for j in range(i + 1, len(num)):
                if dfs(0, i, j):
                    return True
        return False