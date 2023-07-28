class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        
        s = s.replace('-', '').upper()
        if len(s) == 0:
            return s
        if len(s) <= k:
            return s
        n = len(s)
        if n % k == 0:
            return '-'.join([s[i:i+k] for i in range(0, n, k)])
        else:
            return '-'.join([s[:n%k]] + [s[i:i+k] for i in range(n%k, n, k)])