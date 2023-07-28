class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        def restoreIpAddressesHelper(s, k):
            if k == 0:
                return [s] if not s else []
            return [s[:i] + '.' + rest
                    for i in range(1, min(4, len(s) - k + 1))
                    if int(s[:i]) < 256 and (s[0] != '0' or i == 1)
                    for rest in restoreIpAddressesHelper(s[i:], k - 1)]
        return restoreIpAddressesHelper(s, 4)