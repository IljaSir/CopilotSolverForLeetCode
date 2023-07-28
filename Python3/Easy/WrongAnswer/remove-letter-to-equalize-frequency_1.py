class Solution:
    def equalFrequency(self, word: str) -> bool:
        
        
        # We can use a dictionary to count the frequency of each letter. 
        # We can also use a set to keep track of the frequencies of the letters.
        # If there is only one frequency, that means all the letters have the same frequency.
        # If there are two frequencies, that means one letter has a frequency of 1 and the rest have the same frequency.
        # If there are three frequencies, that means two letters have a frequency of 1 and the rest have the same frequency.
        # If there are more than three frequencies, that means it is impossible to remove a letter and have all the frequencies be the same.
        
        freq = {}
        set_freq = set()
        
        for letter in word:
            freq[letter] = freq.get(letter, 0) + 1
            set_freq.add(freq[letter])
            
        if len(set_freq) == 1:
            return True
        if len(set_freq) == 2:
            if 1 in set_freq:
                return True
        if len(set_freq) == 3:
            # We need to make sure that the frequency of 1 is only for one letter.
            count = 0
            for letter in freq:
                if freq[letter] == 1:
                    count += 1
            if count == 1:
                return True
        return False