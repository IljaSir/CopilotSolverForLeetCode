class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        
        # print(words)
        # print(maxWidth)
        i = 0
        n = len(words)
        res = []
        while i < n:
            j = i+1
            l = len(words[i])
            while j < n:
                l += len(words[j])
                if l + j - i - 1 < maxWidth:
                    j += 1
                else:
                    break
            # print(i, j, l)
            s = words[i]
            if j == n:
                for k in range(i+1, j):
                    s += ' ' + words[k]
                s += ' ' * (maxWidth - len(s))
            else:
                if j - i == 1:
                    s += ' ' * (maxWidth - len(s))
                else:
                    space = (maxWidth - l) // (j - i - 1)
                    extra = (maxWidth - l) % (j - i - 1)
                    for k in range(i+1, j):
                        s += ' ' * space
                        if extra > 0:
                            s += ' '
                            extra -= 1
                        s += words[k]
            res.append(s)
            i = j
        return res