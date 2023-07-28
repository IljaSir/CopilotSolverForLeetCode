class Solution:
    def reverseWords(self, s: str) -> str:
        
        # Split the string into a list of words
        words = s.split()
        # Reverse the list of words
        words.reverse()
        # Join the list of words into a string
        return " ".join(words)