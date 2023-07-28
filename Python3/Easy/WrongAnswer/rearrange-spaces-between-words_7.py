class Solution:
    def reorderSpaces(self, text: str) -> str:
        
        text = text.strip()
        spaces = text.count(' ')
        words = text.split()
        if len(words) == 1:
            return words[0] + ' ' * spaces
        else:
            return (' ' * (spaces // (len(words) - 1))).join(words) + ' ' * (spaces % (len(words) - 1))