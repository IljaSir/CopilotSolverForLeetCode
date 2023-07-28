class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        n = len(num)
        if n < 3:
            return []
        
        def dfs(i, j, num, path):
            if i == n:
                if len(path) > 2:
                    return path
                else:
                    return []
            for k in range(j, n):
                if k > i and num[i] == '0':
                    break
                if k - i > 10:
                    break
                if int(num[i:k+1]) > 2**31 - 1:
                    break
                if len(path) >= 2 and int(num[i:k+1]) != path[-1] + path[-2]:
                    continue
                path.append(int(num[i:k+1]))
                res = dfs(k + 1, k + 1, num, path)
                if res:
                    return res
                path.pop()
            return []
        
        return dfs(0, 0, num, [])