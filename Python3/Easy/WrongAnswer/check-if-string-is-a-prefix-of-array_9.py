class Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        
        # This is a prefix string if it can be made by concatenating the first k strings in words
        # for some positive k no larger than words.length.
        # We can loop through the words and check if the string is a prefix of the word
        # If it is, we can remove the prefix from the string and check the next word
        # If it isn't, we can check the next word
        # If we get to the end of the words and the string is empty, then we have a prefix string
        for word in words:
            if s.startswith(word):
                s = s[len(word):]
        return not s