class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        
        # Remove punctuations
        puncs = "!?',;."
        for punc in puncs:
            paragraph = paragraph.replace(punc, ' ')
        # Split paragraph into words
        words = paragraph.split()
        # Convert all words to lower case
        words = [word.lower() for word in words]
        # Create a dictionary with word as key and frequency as value
        word_dict = {}
        for word in words:
            if word in word_dict:
                word_dict[word] += 1
            else:
                word_dict[word] = 1
        # Remove words in banned list
        for word in banned:
            if word in word_dict:
                del word_dict[word]
        # Find the word with highest frequency
        max_freq = 0
        max_word = ''
        for word, freq in word_dict.items():
            if freq > max_freq:
                max_freq = freq
                max_word = word
        return max_word