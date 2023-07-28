class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        
        # if there are less than 2 words, return True
        if len(words) < 2:
            return True
        # create a dictionary to map the order of the alphabet
        order_dict = {}
        for i, letter in enumerate(order):
            order_dict[letter] = i
        # create a dictionary to map the words to their order
        words_dict = {}
        for word in words:
            words_dict[word] = []
            for letter in word:
                words_dict[word].append(order_dict[letter])
        # compare the words by their order
        for i in range(len(words)-1):
            if words_dict[words[i]] > words_dict[words[i+1]]:
                return False
        return True