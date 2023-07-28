class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        # sliding window
        # window size is the number of characters in the window
        # window size is the max number of characters that are not the most frequent character
        # if the window size is greater than k, then we need to shrink the window
        # this is because we need to replace the characters that are not the most frequent character
        # we can shrink the window by moving the start pointer to the right
        # we need to keep track of the most frequent character in the window
        # we can do this by using a counter
        # we can then get the number of characters that are not the most frequent character by subtracting the most frequent character from the window size
        # if the number of characters that are not the most frequent character is greater than k, then we need to shrink the window
        # we can shrink the window by moving the start pointer to the right
        # we need to decrement the counter as we move the start pointer to the right
        # the most frequent character is the character that has the highest value in the counter
        # the window size is the number of characters in the window
        # the window size is the max number of characters that are not the most frequent character
        # the number of characters that are not the most frequent character is the window size minus the most frequent character
        # if the number of characters that are not the most frequent character is greater than k, then we need to shrink the window
        # we can shrink the window by moving the start pointer to the right
        # we need to decrement the counter as we move the start pointer to the right
        # we can return the max window size
        # the max window size is the longest substring containing the same letter we can get after performing the above operations
        # we can initialize the max window size to 0
        max_window_size = 0
        # we can initialize the start pointer to 0
        start = 0
        # we can initialize the counter to 0
        counter = collections.Counter()
        # we can iterate through the string
        for end, char in enumerate(s):
            # we can increment the counter for the current character
            counter[char] += 1
            # we can get the most frequent character
            most_frequent_char = counter.most_common(1)[0][0]
            # we