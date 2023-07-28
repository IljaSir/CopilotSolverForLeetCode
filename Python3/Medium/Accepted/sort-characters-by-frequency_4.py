class Solution:
    def frequencySort(self, s: str) -> str:
        
        chars = {}
        for c in s:
            if c in chars:
                chars[c] += 1
            else:
                chars[c] = 1
        return "".join([c * n for c, n in sorted(chars.items(), key=lambda x: x[1], reverse=True)])