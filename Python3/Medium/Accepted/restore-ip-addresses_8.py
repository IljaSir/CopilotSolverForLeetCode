class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        def is_valid(s):
            if len(s) > 1 and s[0] == '0':
                return False
            return int(s) >= 0 and int(s) <= 255
        
        def dfs(s, i, path, res):
            if i == 4 and len(s) == 0:
                res.append('.'.join(path))
                return
            if i == 4 and len(s) > 0:
                return
            for j in range(1, 4):
                if j <= len(s):
                    if is_valid(s[:j]):
                        dfs(s[j:], i+1, path+[s[:j]], res)
        
        res = []
        dfs(s, 0, [], res)
        return res