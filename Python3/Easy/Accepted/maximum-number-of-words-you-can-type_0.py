class Solution:
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        
        count = 0
        for word in text.split():
            for char in brokenLetters:
                if char in word:
                    break
            else:
                count += 1
        return count