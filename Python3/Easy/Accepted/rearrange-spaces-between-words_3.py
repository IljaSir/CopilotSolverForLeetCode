class Solution:
    def reorderSpaces(self, text: str) -> str:
        
        words = text.split()
        spaces = text.count(' ')
        if len(words) == 1:
            return words[0] + ' ' * spaces
        spaces_between = spaces // (len(words) - 1)
        spaces_at_end = spaces % (len(words) - 1)
        return (' ' * spaces_between).join(words) + ' ' * spaces_at_end