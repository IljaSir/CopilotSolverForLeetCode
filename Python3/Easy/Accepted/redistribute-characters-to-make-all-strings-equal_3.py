class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        
        if len(words) == 1:
            return True
        letters = {}
        for word in words:
            for letter in word:
                if letter not in letters:
                    letters[letter] = 1
                else:
                    letters[letter] += 1
        for letter in letters:
            if letters[letter] % len(words) != 0:
                return False
        return True