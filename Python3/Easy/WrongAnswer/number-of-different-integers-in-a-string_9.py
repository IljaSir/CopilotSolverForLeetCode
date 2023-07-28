class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        
        # Convert to list of integers
        # Remove duplicates
        # Return length of resulting list
        return len(set(int(s) for s in word.split() if s.isdigit()))