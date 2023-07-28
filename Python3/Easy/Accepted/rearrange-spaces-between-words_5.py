class Solution:
    def reorderSpaces(self, text: str) -> str:
        
        words = text.split()
        spaces = text.count(' ')
        if len(words) > 1:
            spaces_between_words = spaces // (len(words) - 1)
            extra_spaces = spaces % (len(words) - 1)
        else:
            spaces_between_words = 0
            extra_spaces = spaces
        return (' ' * spaces_between_words).join(words) + ' ' * extra_spaces