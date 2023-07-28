class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        # Solution 1 - 100 ms
        """
        anagrams = []
        p = list(p)
        for i in range(len(s)):
            if s[i] in p:
                p.remove(s[i])
                if len(p) == 0:
                    anagrams.append(i - len(p))
                    p.append(s[i - len(p) + 1])
            else:
                p = list(p)
        return anagrams
        """
        # Solution 2 - 96 ms
        from collections import Counter
        c = Counter(p)
        res = []
        for i in range(len(s)):
            if s[i] in c:
                c[s[i]] -= 1
                if c[s[i]] == 0:
                    del c[s[i]]
                if i >= len(p):
                    if s[i - len(p)] in c:
                        c[s[i - len(p)]] += 1
                        if c[s[i - len(p)]] == 0:
                            del c[s[i - len(p)]]
                if len(c) == 0:
                    res.append(i - len(p) + 1)
            else:
                c = Counter(p)
                if i >= len(p):
                    if s[i - len(p)] in c:
                        c[s[i - len(p)]] += 1
                        if c[s[i - len(p)]] == 0:
                            del c[s[i - len(p)]]
        return res