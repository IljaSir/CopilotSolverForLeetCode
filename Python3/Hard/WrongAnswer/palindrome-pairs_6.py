class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        
        def is_palin(s):
            return s == s[::-1]
        
        def find_palin(s):
            nonlocal words
            if s in words:
                return words[s]
            for i in range(len(s)):
                if is_palin(s[:i]) and s[i:] in words:
                    return words[s[i:]]
            return -1
        
        words = {w:i for i, w in enumerate(words)}
        res = set()
        for i, w in enumerate(words):
            for j in range(len(w)+1):
                if is_palin(w[j:]):
                    left = find_palin(w[:j][::-1])
                    if left != -1 and left != i:
                        res.add((left, i))
                if j != 0 and is_palin(w[:j]):
                    right = find_palin(w[j:][::-1])
                    if right != -1 and right != i:
                        res.add((i, right))
        return list(res)