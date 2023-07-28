class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        
        if len(words) == 0:
            return []
        if len(words) == 1:
            return [words[0] + ' '*(maxWidth-len(words[0]))]
        res = []
        i = 0
        while i < len(words):
            line = ''
            j = i
            while j < len(words) and len(line) + len(words[j]) <= maxWidth:
                line += words[j] + ' '
                j += 1
            line = line[:-1]
            if j == len(words):
                line += ' '*(maxWidth-len(line))
                res.append(line)
                break
            if j - i == 1:
                line += ' '*(maxWidth-len(line))
                res.append(line)
                i = j
                continue
            space = maxWidth - len(line) + j - i - 1
            space_list = [' ' for _ in range(space)]
            pos = 0
            while len(line) < maxWidth:
                line = line[:pos] + ' ' + line[pos:]
                pos += len(words[i]) + 2
                i += 1
            res.append(line)
            i = j
        return res