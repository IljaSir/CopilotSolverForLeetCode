class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        def helper(s, k):
            if k == 0:
                return [s] if not s else []
            res = []
            for i in range(1, 4):
                if i <= len(s) and int(s[:i]) <= 255:
                    if s[:i].startswith('0') and len(s[:i]) > 1:
                        continue
                    res += [s[:i] + '.' + rest for rest in helper(s[i:], k - 1)]
            return res
        return helper(s, 4)