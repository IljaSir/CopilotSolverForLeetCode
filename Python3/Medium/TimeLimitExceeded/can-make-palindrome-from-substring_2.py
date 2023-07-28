class Solution:
    def canMakePaliQueries(self, s: str, queries: List[List[int]]) -> List[bool]:
        
        # Solution 1 - 6584 ms
        """
        res = []
        for query in queries:
            l, r, k = query
            sub = s[l:r + 1]
            cnt = 0
            for i in range(26):
                cnt += sub.count(chr(ord('a') + i)) % 2
            res.append(cnt // 2 <= k)
        return res
        """
        # Solution 2 - 384 ms
        def is_palindrome(s):
            cnt = 0
            for i in range(26):
                cnt += s.count(chr(ord('a') + i)) % 2
            return cnt // 2 <= k

        res = []
        for l, r, k in queries:
            sub = s[l:r + 1]
            res.append(is_palindrome(sub))
        return res