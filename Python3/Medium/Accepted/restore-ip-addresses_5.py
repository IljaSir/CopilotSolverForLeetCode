class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        if len(s) > 12:
            return []
        def dfs(s, k, path, res):
            if k == 4:
                if not s:
                    res.append(path[:-1])
                return
            for i in range(1, 4):
                if i <= len(s):
                    if i == 1:
                        dfs(s[i:], k+1, path+s[:i]+'.', res)
                    elif i == 2 and s[0] != '0':
                        dfs(s[i:], k+1, path+s[:i]+'.', res)
                    elif i == 3 and s[0] != '0' and int(s[:3]) <= 255:
                        dfs(s[i:], k+1, path+s[:i]+'.', res)
        res = []
        dfs(s, 0, '', res)
        return res