class Solution:
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        
        def is_subseq(s, t):
            i = 0
            j = 0
            while i < len(s) and j < len(t):
                if s[i] == t[j]:
                    i += 1
                j += 1
            return i == len(s)
        dictionary.sort(key=lambda x: (-len(x), x))
        for word in dictionary:
            if is_subseq(word, s):
                return word
        return ""