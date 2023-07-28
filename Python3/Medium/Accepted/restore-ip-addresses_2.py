class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        def backtrack(s, path, res):
            if len(path) == 4 and not s:
                res.append(".".join(path))
                return
            for i in range(1, 4):
                if i <= len(s):
                    if int(s[:i]) <= 255:
                        backtrack(s[i:], path + [s[:i]], res)
                    if s[0] == "0":
                        break
        res = []
        backtrack(s, [], res)
        return res