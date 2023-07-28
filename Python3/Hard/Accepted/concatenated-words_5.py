class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        
        def isConcatenated(word, words, cache):
            if word in cache:
                return cache[word]
            for i in range(1, len(word)):
                prefix = word[:i]
                suffix = word[i:]
                if prefix in words and suffix in words:
                    cache[word] = True
                    return True
                if prefix in words and isConcatenated(suffix, words, cache):
                    cache[word] = True
                    return True
                if suffix in words and isConcatenated(prefix, words, cache):
                    cache[word] = True
                    return True
            cache[word] = False
            return False
        
        words = set(words)
        cache = {}
        res = []
        for word in words:
            if isConcatenated(word, words, cache):
                res.append(word)
        return res