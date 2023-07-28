class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        def dfs(num, target, path, prev, cur, res):
            if not num and cur == target:
                res.append(path)
                return
            for i in range(1, len(num) + 1):
                s = num[:i]
                if len(s) > 1 and s[0] == '0':
                    return
                n = int(s)
                dfs(num[i:], target, path + '+' + s, n, cur + n, res)
                dfs(num[i:], target, path + '-' + s, -n, cur - n, res)
                dfs(num[i:], target, path + '*' + s, prev * n, cur - prev + prev * n, res)
        res = []
        for i in range(1, len(num) + 1):
            s = num[:i]
            if len(s) > 1 and s[0] == '0':
                return res
            dfs(num[i:], target, s, int(s), int(s), res)
        return res