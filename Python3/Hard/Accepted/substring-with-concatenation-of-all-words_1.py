class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        
        n = len(s)
        m = len(words)
        if n == 0 or m == 0:
            return []
        wlen = len(words[0])
        if n < m * wlen:
            return []
        ans = []
        words = Counter(words)
        for i in range(0, n - m * wlen + 1):
            if s[i:i + wlen] in words:
                j = i
                tmp = words.copy()
                while j < i + m * wlen:
                    w = s[j:j + wlen]
                    if w in tmp:
                        tmp[w] -= 1
                        if tmp[w] == 0:
                            del tmp[w]
                        j += wlen
                    else:
                        break
                if len(tmp) == 0:
                    ans.append(i)
        return ans