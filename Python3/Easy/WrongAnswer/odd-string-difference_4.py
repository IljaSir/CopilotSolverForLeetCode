class Solution:
    def oddString(self, words: List[str]) -> str:
        
        for word in words:
            if len(set([ord(char) - ord(word[i-1]) for i, char in enumerate(word) if i > 0])) == 1:
                return word