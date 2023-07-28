class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        
        # Replace all non-digits with space
        word = re.sub(r'[^0-9]', ' ', word)
        # Replace all leading zeros with empty string
        word = re.sub(r'0*', '', word)
        # Split into list of integers
        word = word.split()
        return len(set(word))