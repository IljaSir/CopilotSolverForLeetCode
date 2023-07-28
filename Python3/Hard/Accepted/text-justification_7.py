class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        
        def justify(words, maxWidth):
            if len(words) == 1:
                return words[0] + " " * (maxWidth - len(words[0]))
            else:
                space = maxWidth - sum(len(word) for word in words)
                per_space = space // (len(words) - 1)
                extra_space = space % (len(words) - 1)
                return (" " * (per_space + 1)).join(words[:extra_space + 1]) + " " * per_space + (" " * per_space).join(words[extra_space + 1:])
        lines = []
        line = []
        line_len = 0
        for word in words:
            if line_len + len(word) + len(line) <= maxWidth:
                line.append(word)
                line_len += len(word)
            else:
                lines.append(justify(line, maxWidth))
                line = [word]
                line_len = len(word)
        lines.append(" ".join(line) + " " * (maxWidth - line_len - len(line) + 1))
        return lines