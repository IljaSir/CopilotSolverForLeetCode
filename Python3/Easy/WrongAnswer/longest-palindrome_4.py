class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        # Get the frequency of each letter
        letter_freq = {}
        for letter in s:
            if letter not in letter_freq:
                letter_freq[letter] = 1
            else:
                letter_freq[letter] += 1
        # Get the number of pairs of letters
        num_pairs = 0
        for letter in letter_freq:
            num_pairs += letter_freq[letter] // 2
        # If there are odd numbers of letters in the string, then we can add 1 to the number of pairs
        if num_pairs * 2 < len(s):
            num_pairs += 1
        # Return the number of pairs multiplied by 2
        return num_pairs * 2