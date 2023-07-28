class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        
        s = s.replace('-', '').upper()
        if s == '':
            return ''
        mod = len(s) % k
        if mod == 0:
            mod = k
        result = s[:mod]
        for i in range(mod, len(s), k):
            result += '-' + s[i:i+k]
        return result