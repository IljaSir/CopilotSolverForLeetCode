class Solution:
    def vowelStrings(self, words: List[str], left: int, right: int) -> int:
        
        vowels = 'aeiou'
        def is_vowel_string(word):
            return word[0] in vowels and word[-1] in vowels
        return sum(is_vowel_string(word) for word in words[left:right+1])