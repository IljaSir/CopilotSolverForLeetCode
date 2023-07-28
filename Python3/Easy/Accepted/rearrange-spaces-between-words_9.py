class Solution:
    def reorderSpaces(self, text: str) -> str:
        
        words = text.split()
        if len(words) == 1:
            return words[0] + ' ' * (len(text) - len(words[0]))
        spaces = text.count(' ')
        spaces_per_word = spaces // (len(words) - 1)
        spaces_left = spaces % (len(words) - 1)
        return (' ' * spaces_per_word).join(words) + ' ' * spaces_left