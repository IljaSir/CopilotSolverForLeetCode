class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        def is_valid(s):
            if len(s) > 1 and s[0] == '0':
                return False
            return int(s) <= 255
        
        def backtracking(s, path, res):
            if len(path) == 4 and not s:
                res.append('.'.join(path))
                return
            for i in range(1, 4):
                if i <= len(s):
                    if is_valid(s[:i]):
                        backtracking(s[i:], path + [s[:i]], res)
        
        res = []
        backtracking(s, [], res)
        return res