class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        
        def justify(line, maxWidth):
            if len(line) == 1:
                return line[0] + ' ' * (maxWidth - len(line[0]))
            spaces = maxWidth - sum([len(w) for w in line])
            gaps = len(line) - 1
            if spaces % gaps == 0:
                gap = spaces // gaps
                return (' ' * gap).join(line)
            else:
                gap = spaces // gaps
                extra = spaces % gaps
                return (' ' * (gap + 1)).join(line[:extra]) + ' ' * gap + (' ' * gap).join(line[extra:])
        res = []
        line = []
        line_len = 0
        for w in words:
            if len(w) + line_len + len(line) > maxWidth:
                res.append(justify(line, maxWidth))
                line = []
                line_len = 0
            line.append(w)
            line_len += len(w)
        res.append(' '.join(line) + ' ' * (maxWidth - len(' '.join(line))))
        return res