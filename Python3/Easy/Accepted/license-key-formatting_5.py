class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        
        s = s.replace('-', '').upper()
        if len(s) <= k:
            return s
        result = []
        for i in range(len(s) - 1, -1, -k):
            result.append(s[max(0, i - k + 1):i + 1])
        return '-'.join(result[::-1])