class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        def dfs(s, path, res, depth):
            if depth == 4:
                if not s:
                    res.append(path[:-1])
                return
            
            for i in range(1, 4):
                if i <= len(s):
                    if i == 1:
                        dfs(s[i:], path + s[:i] + '.', res, depth + 1)
                    elif i == 2 and s[0] != '0':
                        dfs(s[i:], path + s[:i] + '.', res, depth + 1)
                    elif i == 3 and s[0] != '0' and int(s[:3]) <= 255:
                        dfs(s[i:], path + s[:i] + '.', res, depth + 1)
        res = []
        dfs(s, '', res, 0)
        return res