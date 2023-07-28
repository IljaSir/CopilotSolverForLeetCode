class Solution:
    def printVertically(self, s: str) -> List[str]:
        
        words = s.split()
        max_len = max(map(len, words))
        res = []
        for i in range(max_len):
            res.append(''.join([word[i] if i < len(word) else ' ' for word in words]))
        return res