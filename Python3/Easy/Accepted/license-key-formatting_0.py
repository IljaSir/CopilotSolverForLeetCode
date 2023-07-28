class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        
        s = s.upper().replace('-', '')
        s = s[::-1]
        s = '-'.join([s[i:i+k] for i in range(0, len(s), k)])
        return s[::-1]