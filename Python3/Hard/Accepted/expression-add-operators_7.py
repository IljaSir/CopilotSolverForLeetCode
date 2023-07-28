class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        def dfs(s, path, val, last):
            if not s:
                if val == target:
                    res.append(path)
                return
            for i in range(1, len(s)+1):
                if i > 1 and s[0] == '0':
                    break
                cur = int(s[:i])
                if not path:
                    dfs(s[i:], str(cur), cur, cur)
                else:
                    dfs(s[i:], path + '+' + str(cur), val + cur, cur)
                    dfs(s[i:], path + '-' + str(cur), val - cur, -cur)
                    dfs(s[i:], path + '*' + str(cur), val - last + last * cur, last * cur)
        res = []
        dfs(num, '', 0, 0)
        return res