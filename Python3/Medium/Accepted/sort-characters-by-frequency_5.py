class Solution:
    def frequencySort(self, s: str) -> str:
        
        from collections import Counter
        c = Counter(s)
        c = sorted(c.items(), key=lambda x: x[1], reverse=True)
        return ''.join([i[0] * i[1] for i in c])