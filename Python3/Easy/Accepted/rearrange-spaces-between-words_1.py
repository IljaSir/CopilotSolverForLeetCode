class Solution:
    def reorderSpaces(self, text: str) -> str:
        
        spaces = text.count(' ')
        words = text.split()
        if len(words) == 1:
            return words[0] + ' ' * spaces
        spaces_between_words = spaces // (len(words) - 1)
        extra_spaces = spaces % (len(words) - 1)
        return (' ' * spaces_between_words).join(words) + ' ' * extra_spaces