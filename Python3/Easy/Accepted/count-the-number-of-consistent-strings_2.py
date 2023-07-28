class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        
        result = 0
        for word in words:
            for letter in word:
                if letter not in allowed:
                    break
            else:
                result += 1
        return result