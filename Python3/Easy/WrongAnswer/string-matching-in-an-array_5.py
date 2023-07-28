class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        
        result = []
        for word in words:
            for word2 in words:
                if word == word2:
                    continue
                if word in word2:
                    result.append(word)
        return result