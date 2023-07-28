class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        def isValid(s):
            if not s or (len(s) > 1 and s[0] == '0') or int(s) > 255:
                return False
            return True
        def dfs(s, n, ip, ips):
            if n == 1:
                if isValid(s):
                    ips.append(ip + s)
                return
            for i in range(1, min(4, len(s))):
                if isValid(s[:i]):
                    dfs(s[i:], n-1, ip + s[:i] + '.', ips)
        ips = []
        dfs(s, 4, '', ips)
        return ips