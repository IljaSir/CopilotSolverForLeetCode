class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        
        # create a dict to store the index of each word
        # we can use this dict to get the index of a word in O(1) time
        word_dict = {word: i for i, word in enumerate(words)}
        # create a list to store the result
        result = []
        # loop through all the words
        for i, word in enumerate(words):
            # loop through all the possible suffixes
            for j in range(len(word) + 1):
                # get the prefix and suffix of the current word
                prefix, suffix = word[:j], word[j:]
                # if the prefix is a palindrome and the reversed suffix is in the dict
                # and the reversed suffix is not the current word
                if prefix == prefix[::-1] and suffix[::-1] in word_dict and word_dict[suffix[::-1]] != i:
                    # add the reversed suffix index and the current word index to the result
                    result.append([word_dict[suffix[::-1]], i])
                # if the suffix is a palindrome and the reversed prefix is in the dict
                # and the reversed prefix is not the current word
                if j != len(word) and suffix == suffix[::-1] and prefix[::-1] in word_dict and word_dict[prefix[::-1]] != i:
                    # add the current word index and the reversed prefix index to the result
                    result.append([i, word_dict[prefix[::-1]]])
        # return the result
        return result