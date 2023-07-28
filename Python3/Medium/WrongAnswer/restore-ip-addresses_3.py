class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        def dfs(s, k, ip, ips):
            if k == 0:
                ips.append(ip[1:])
                return
            for i in range(1, 4):
                if i <= len(s):
                    if int(s[:i]) <= 255:
                        dfs(s[i:], k - 1, ip + '.' + s[:i], ips)
                    if s[0] == '0':
                        break
        ips = []
        dfs(s, 4, '', ips)
        return ips