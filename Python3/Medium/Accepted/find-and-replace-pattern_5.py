class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        
        def is_match(word):
            d1 = {}
            d2 = {}
            for i in range(len(word)):
                if word[i] not in d1:
                    d1[word[i]] = pattern[i]
                if pattern[i] not in d2:
                    d2[pattern[i]] = word[i]
                if d1[word[i]] != pattern[i] or d2[pattern[i]] != word[i]:
                    return False
            return True
        return [word for word in words if is_match(word)]