class Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        
        l = len(s)
        for i, word in enumerate(words):
            if word == s[:len(word)]:
                l -= len(word)
                if l == 0:
                    return True
            else:
                return False
        return False