class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        
        # 1. Create a dictionary to store the order of each character
        # 2. For each word, check the order of each pair of adjacent characters
        # 3. If the order of a pair of adjacent characters is not in the right order, return False
        # 4. If all the pairs of adjacent characters are in the right order, return True
        # Time  complexity: O(N * M)
        # Space complexity: O(1)
        # where N is the number of words, and M is the length of each word
        # Create a dictionary to store the order of each character
        order_dict = {}
        for index, char in enumerate(order):
            order_dict[char] = index
        # For each word, check the order of each pair of adjacent characters
        for word_index in range(len(words) - 1):
            word1 = words[word_index]
            word2 = words[word_index + 1]
            # If the length of word1 is longer than the length of word2, and the first few characters of word1 are the same as word2, return False
            if len(word1) > len(word2) and word1[:len(word2)] == word2:
                return False
            # For each pair of adjacent characters in word1 and word2, check the order of these characters
            for char_index in range(min(len(word1), len(word2))):
                # If the order of these characters is not in the right order, return False
                if order_dict[word1[char_index]] < order_dict[word2[char_index]]:
                    break
                elif order_dict[word1[char_index]] > order_dict[word2[char_index]]:
                    return False
        # If all the pairs of adjacent characters are in the right order, return True
        return True