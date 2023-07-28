class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        
        def justify(line, maxWidth):
            if len(line) == 1:
                return line[0] + ' '*(maxWidth - len(line[0]))
            spaces = maxWidth - sum(len(w) for w in line)
            n = len(line) - 1
            q, r = divmod(spaces, n)
            return (' '*(q+1)).join(line[:r+1]) + ' '*q + (' '*(q)).join(line[r+1:])
        ans, line, n = [], [], 0
        for w in words:
            if n + len(w) + len(line) > maxWidth:
                ans.append(justify(line, maxWidth))
                line, n = [], 0
            line += [w]
            n += len(w)
        return ans + [' '.join(line).ljust(maxWidth)]