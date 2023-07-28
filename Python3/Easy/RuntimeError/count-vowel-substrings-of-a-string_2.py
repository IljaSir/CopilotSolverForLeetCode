class Solution:
    def countVowelSubstrings(self, word: str) -> int:
        
        # The idea is to find the longest substring with all 5 vowels
        # The longest substring is the smallest substring with all 5 vowels
        # So we need to find the smallest substring with all 5 vowels
        # We have to start from the first vowel
        # We have to end with the last vowel