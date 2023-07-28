class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        
        # Get the frequency of each character
        # Check if all the frequencies are the same
        char_freq = {}
        for char in s:
            if char in char_freq:
                char_freq[char] += 1
            else:
                char_freq[char] = 1
        # print(char_freq)
        # Check if all the frequencies are the same
        # print(len(set(char_freq.values())))
        if len(set(char_freq.values())) == 1:
            return True
        else:
            return False