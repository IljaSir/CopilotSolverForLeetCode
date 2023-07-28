class Solution:
    def printVertically(self, s: str) -> List[str]:
        
        if not s:
            return []
        words = s.split()
        max_len = max(map(len, words))
        result = []
        for i in range(max_len):
            word = ''
            for w in words:
                if i < len(w):
                    word += w[i]
                else:
                    word += ' '
            result.append(word.rstrip())
        return result