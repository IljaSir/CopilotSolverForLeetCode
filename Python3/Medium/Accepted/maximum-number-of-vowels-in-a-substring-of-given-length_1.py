class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        
        max_vowels = 0
        vowels = 0
        for i in range(len(s)):
            if s[i] in "aeiou":
                vowels += 1
            if i >= k and s[i-k] in "aeiou":
                vowels -= 1
            max_vowels = max(max_vowels, vowels)
        return max_vowels