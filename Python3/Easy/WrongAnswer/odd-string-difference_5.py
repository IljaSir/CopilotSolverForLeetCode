class Solution:
    def oddString(self, words: List[str]) -> str:
        
        for word in words:
            if words.count(word) % 2 == 1:
                return word