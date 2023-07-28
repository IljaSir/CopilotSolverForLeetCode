class Solution:
    def reorderSpaces(self, text: str) -> str:
        
        words = text.split()
        spaces = len(text) - sum(len(w) for w in words)
        if len(words) == 1:
            return words[0] + ' ' * spaces
        else:
            return (' ' * (spaces // (len(words) - 1))).join(words) + ' ' * (spaces % (len(words) - 1))