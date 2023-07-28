class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        
        # The idea is to find the number of unique suffixes.
        # The number of unique suffixes is equal to the number of unique words in the reversed list of words.
        # So, we reverse each word and find the number of unique words in the reversed list.
        # The length of the shortest encoding is the sum of the lengths of the words plus the number of unique words.
        return sum(len(word) + 1 for word in set(word[::-1] for word in words)) - len(set(word[::-1] for word in words))