class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        
        res = []
        i = 0
        while i < len(words):
            j = i + 1
            line = words[i]
            while j < len(words):
                if len(line) + len(words[j]) + 1 > maxWidth:
                    break
                line += ' ' + words[j]
                j += 1
            if j == len(words):
                line += ' ' * (maxWidth - len(line))
            else:
                if j - i > 1:
                    num_spaces = maxWidth - len(line)
                    num_spaces_per_word = num_spaces // (j - i - 1)
                    num_spaces_left = num_spaces % (j - i - 1)
                    for k in range(i + 1, j):
                        line = line[:len(line) - len(words[k - 1])] + ' ' * num_spaces_per_word + line[len(line) - len(words[k - 1]):]
                        if num_spaces_left > 0:
                            line = line[:len(line) - len(words[k - 1])] + ' ' + line[len(line) - len(words[k - 1]):]
                            num_spaces_left -= 1
                else:
                    line += ' ' * (maxWidth - len(line))
            res.append(line)
            i = j
        return res