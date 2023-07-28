class Solution:
    def vowelStrings(self, words: List[str], left: int, right: int) -> int:
        
        vowel = 'aeiou'
        count = 0
        for i in range(left, right+1):
            for j in range(len(words[i])):
                if words[i][j] in vowel:
                    count += 1
        return count