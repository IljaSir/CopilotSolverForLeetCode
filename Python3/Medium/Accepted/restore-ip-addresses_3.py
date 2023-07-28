class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        def check(s):
            if len(s) > 1 and s[0] == "0":
                return False
            if int(s) > 255:
                return False
            return True
        
        def dfs(s, path, res):
            if len(path) == 4 and len(s) == 0:
                res.append(".".join(path))
                return
            for i in range(1, 4):
                if i <= len(s):
                    if check(s[:i]):
                        dfs(s[i:], path + [s[:i]], res)
        
        res = []
        dfs(s, [], res)
        return res