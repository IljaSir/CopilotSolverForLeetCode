class Solution:
    def vowelStrings(self, words: List[str], left: int, right: int) -> int:
        
        vowel = set("aeiou")
        return sum(all(c in vowel for c in word) for word in words[left:right+1])