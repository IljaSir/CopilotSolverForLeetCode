class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        
        s = s.replace('-', '').upper()
        n = len(s)
        if n == 0:
            return ''
        if n % k == 0:
            return '-'.join([s[i:i+k] for i in range(0, n, k)])
        else:
            return s[:n%k] + '-' + '-'.join([s[i:i+k] for i in range(n%k, n, k)])