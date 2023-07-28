class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        # Solution 1 - 1000 ms
        """
        def is_subseq(s, t):
            it = iter(t)
            return all(c in it for c in s)

        return sum(is_subseq(word, s) for word in words)
        """
        # Solution 2 - 1000 ms
        """
        def is_subseq(s, t):
            i = 0
            for c in t:
                if i < len(s) and c == s[i]:
                    i += 1
            return i == len(s)

        return sum(is_subseq(word, s) for word in words)
        """
        # Solution 3 - 1000 ms
        """
        def is_subseq(s, t):
            i = 0
            for c in t:
                if i == len(s):
                    break
                if c == s[i]:
                    i += 1
            return i == len(s)

        return sum(is_subseq(word, s) for word in words)
        """
        # Solution 4 - 104 ms
        # https://leetcode.com/problems/number-of-matching-subsequences/discuss/117598/Python-3-lines-104-ms
        from collections import defaultdict
        from bisect import bisect_left
        waiting = defaultdict(list)
        for word in words:
            waiting[word[0]].append(iter(word[1:]))
        for c in s:
            for it in waiting.pop(c, ()):
                waiting[next(it, None)].append(it)
        return len(waiting[None])