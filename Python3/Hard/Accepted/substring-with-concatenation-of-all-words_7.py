class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        
        if not s or not words:
            return []
        n = len(words[0])
        m = len(words)
        word_map = collections.Counter(words)
        res = []
        for i in range(len(s) - n * m + 1):
            j = 0
            while j < m:
                word = s[i + j * n: i + j * n + n]
                if word in word_map:
                    word_map[word] -= 1
                    if word_map[word] < 0:
                        break
                else:
                    break
                j += 1
            if j == m:
                res.append(i)
            word_map = collections.Counter(words)
        return res