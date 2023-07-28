class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        def dfs(s, parts, res):
            if len(parts) == 3:
                if s[0] == '0' and len(s) > 1 or int(s) > 255:
                    return
                res.append('.'.join(parts) + '.' + s)
                return
            for i in range(1, 4):
                if s[0] == '0' and i > 1 or int(s[:i]) > 255:
                    break
                dfs(s[i:], parts + [s[:i]], res)
        if len(s) < 4 or len(s) > 12:
            return []
        res = []
        dfs(s, [], res)
        return res