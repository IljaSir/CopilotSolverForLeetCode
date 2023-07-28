class Solution:
    def reorderSpaces(self, text: str) -> str:
        
        spaces = 0
        words = []
        for c in text:
            if c == ' ':
                spaces += 1
            else:
                if not words or words[-1] == ' ':
                    words.append(c)
                else:
                    words[-1] += c
        if len(words) == 1:
            return words[0] + ' ' * spaces
        else:
            spaces_per_word = spaces // (len(words) - 1)
            extra_spaces = spaces % (len(words) - 1)
            return (' ' * spaces_per_word).join(words) + ' ' * extra_spaces