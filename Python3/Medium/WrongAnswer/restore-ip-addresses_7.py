class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        result = []
        def dfs(s, path, step):
            if step == 4:
                if not s:
                    result.append(path)
                return
            for i in range(1, 4):
                if i <= len(s):
                    if i == 1:
                        dfs(s[i:], path + s[:i] + '.', step + 1)
                    elif i == 2 and s[0] != '0':
                        dfs(s[i:], path + s[:i] + '.', step + 1)
                    elif i == 3 and s[0] != '0' and int(s[:3]) <= 255:
                        dfs(s[i:], path + s[:i] + '.', step + 1)
        dfs(s, '', 0)
        return result