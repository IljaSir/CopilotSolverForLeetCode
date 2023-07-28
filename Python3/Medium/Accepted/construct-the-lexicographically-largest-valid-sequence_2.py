class Solution:
    def constructDistancedSequence(self, n: int) -> List[int]:
        
        def dfs(idx, n):
            if idx == len(res):
                return True
            if res[idx]:
                return dfs(idx + 1, n)
            for i in range(n, 0, -1):
                if used[i]:
                    continue
                if i != 1 and (idx + i >= len(res) or res[idx + i]):
                    continue
                res[idx] = i
                used[i] = True
                if i != 1:
                    res[idx + i] = i
                if dfs(idx + 1, n):
                    return True
                res[idx] = 0
                used[i] = False
                if i != 1:
                    res[idx + i] = 0
            return False
        res = [0] * (2 * n - 1)
        used = [False] * (n + 1)
        dfs(0, n)
        return res