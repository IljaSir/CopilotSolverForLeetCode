class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        
        d, res = collections.defaultdict(int), 0
        for w in words:
            d[w] += 1
        for w in d:
            if d[w] > 1:
                if w[0] == w[1]:
                    res += d[w] // 2 * 2
                else:
                    if d[w[::-1]] > 0:
                        res += min(d[w], d[w[::-1]]) * 2
                        d[w] = d[w[::-1]] = 0
        for w in d:
            if d[w] > 0 and w[0] == w[1]:
                res += 1
                break
        return res