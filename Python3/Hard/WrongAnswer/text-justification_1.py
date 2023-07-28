class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        
        lines = []
        line = []
        line_length = 0
        for word in words:
            if len(word) + line_length + len(line) > maxWidth:
                lines.append(line)
                line = []
                line_length = 0
            line.append(word)
            line_length += len(word)
        lines.append(line)
        result = []
        for line in lines[:-1]:
            if len(line) == 1:
                result.append(line[0] + ' ' * (maxWidth - len(line[0])))
            else:
                line_length = sum([len(word) for word in line])
                spaces = maxWidth - line_length
                spaces_per_word = spaces // (len(line) - 1)
                spaces_left = spaces % (len(line) - 1)
                result.append(' ' * spaces_left + (' ' * spaces_per_word).join(line))
        result.append(' '.join(lines[-1]) + ' ' * (maxWidth - sum([len(word) for word in lines[-1]])))
        return result