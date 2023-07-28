class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        
        s = s.replace('-', '').upper()
        n = len(s)
        if n == 0:
            return ''
        if n == 1:
            return s
        return self.licenseKeyFormatting(s[:-k], k) + '-' + s[-k:]