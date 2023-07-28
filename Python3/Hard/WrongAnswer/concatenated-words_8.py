class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        
        def search(word, i, j, count):
            if count > 1 and j == len(word):
                return True
            if i == len(word):
                return False
            for k in range(i, len(word)):
                if word[i:k+1] in word_set:
                    if search(word, k+1, j+1, count+1):
                        return True
            return False
        word_set = set(words)
        result = []
        for word in words:
            if search(word, 0, 0, 0):
                result.append(word)
        return result