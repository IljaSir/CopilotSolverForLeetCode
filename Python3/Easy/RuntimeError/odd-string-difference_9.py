class Solution:
    def oddString(self, words: List[str]) -> str:
        
        # The idea is to find the first character that is different in each word.
        # Then we can compare the difference between each word and the first word.
        # If the difference is the same, then we can return the first word, otherwise, we can return the word that is different.
        # This is because the first character is different, so the difference between the first word and the other words will be different.
        # We can use a set to check if the difference is the same.
        # If the difference is the same, then the set will only have 1 item.
        # If the difference is different, then the set will have 2 items.
        # The first item is the difference between the first word and the other words.
        # The second item is the difference between the word that is different and the other words.
        # The first item is different from the second item, so we can return the word that is different.
        # The first word is the first item in the list.
        first_word = words[0]
        # Loop through each word in the list.
        for word in words:
            # Loop through each character in the word.
            for i in range(len(word)):
                # If the first word has a different character, then we can compare the difference between each word and the first word.
                if first_word[i] != word[i]:
                    # Create a set.
                    set_ = set()
                    # Loop through each character in the first word.
                    for j in range(len(first_word)):
                        # If the first word has a different character, then we can compare the difference between each word and the first word.
                        if