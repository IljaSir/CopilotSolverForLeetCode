class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        
        s = s.replace('-', '').upper()
        i = len(s) % k
        if i == 0:
            i = k
        result = s[:i]
        while i < len(s):
            result += '-' + s[i:i+k]
            i += k
        return result