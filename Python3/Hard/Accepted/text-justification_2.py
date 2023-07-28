class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        
        def justify(line, maxWidth):
            if len(line) == 1:
                return line[0] + ' ' * (maxWidth - len(line[0]))
            spaces = maxWidth - sum([len(word) for word in line])
            num_spaces = len(line) - 1
            spaces_per_word = spaces // num_spaces
            extra_spaces = spaces % num_spaces
            res = ''
            for i in range(num_spaces):
                res += line[i]
                if i < extra_spaces:
                    res += ' ' * (spaces_per_word + 1)
                else:
                    res += ' ' * spaces_per_word
            res += line[-1]
            return res
        res = []
        line = []
        line_len = 0
        for word in words:
            if line_len + len(word) + len(line) > maxWidth:
                res.append(justify(line, maxWidth))
                line = []
                line_len = 0
            line.append(word)
            line_len += len(word)
        res.append(' '.join(line) + ' ' * (maxWidth - line_len - len(line) + 1))
        return res