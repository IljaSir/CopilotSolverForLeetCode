class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        def dfs(s, start, path, res):
            if start == len(s) and len(path) == 4:
                res.append('.'.join(path))
            elif start < len(s) and len(path) < 4:
                for i in range(start, start + 3):
                    if i < len(s):
                        if i == start and s[i] == '0' or i > start and int(s[start:i + 1]) <= 255:
                            path.append(s[start:i + 1])
                            dfs(s, i + 1, path, res)
                            path.pop()
        res = []
        dfs(s, 0, [], res)
        return res