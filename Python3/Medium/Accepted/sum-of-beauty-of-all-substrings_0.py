class Solution:
    def beautySum(self, s: str) -> int:
        
        beauty = 0
        for i in range(len(s)):
            freq = {}
            for j in range(i, len(s)):
                if s[j] not in freq:
                    freq[s[j]] = 0
                freq[s[j]] += 1
                beauty += max(freq.values()) - min(freq.values())
        return beauty