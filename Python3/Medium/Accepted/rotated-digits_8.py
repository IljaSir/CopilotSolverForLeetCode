class Solution:
    def rotatedDigits(self, n: int) -> int:
        
        self.res = 0
        def dfs(num, n):
            if num > n:
                return
            if '3' not in str(num) and '4' not in str(num) and '7' not in str(num):
                if '2' in str(num) or '5' in str(num) or '6' in str(num) or '9' in str(num):
                    self.res += 1
            for i in range(10):
                dfs(num*10+i, n)
        for i in range(1, 10):
            dfs(i, n)
        return self.res