class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        def dfs(i, j, num):
            if num[i] == '0' and j - i > 1:
                return False
            if num[j] == '0' and len(num) - j > 1:
                return False
            a, b = int(num[:i]), int(num[i:j])
            for k in range(j, len(num)):
                c = a + b
                if num[k:].startswith(str(c)):
                    if k == len(num) - 1:
                        return True
                    if dfs(j, k + 1, num):
                        return True
            return False
        for i in range(1, len(num)):
            for j in range(i + 1, len(num)):
                if dfs(i, j, num):
                    return True
        return False