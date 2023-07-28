class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        
        def find_match(word):
            p = {}
            w = {}
            for i in range(len(word)):
                if word[i] in w:
                    if w[word[i]] != pattern[i]:
                        return False
                else:
                    w[word[i]] = pattern[i]
                if pattern[i] in p:
                    if p[pattern[i]] != word[i]:
                        return False
                else:
                    p[pattern[i]] = word[i]
            return True
        return [word for word in words if find_match(word)]