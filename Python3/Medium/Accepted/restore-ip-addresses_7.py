class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        def dfs(s, path, res):
            if len(path) == 4 and s == '':
                res.append('.'.join(path))
                return
            for i in range(1, len(s)+1):
                if i > 3 or (i > 1 and s[0] == '0') or int(s[:i]) > 255:
                    continue
                dfs(s[i:], path+[s[:i]], res)
        res = []
        dfs(s, [], res)
        return res