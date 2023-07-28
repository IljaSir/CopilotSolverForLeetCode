class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        
        s = [int(i) for i in secret]
        g = [int(i) for i in guess]
        bull, cow = 0, 0
        for i in range(len(s)):
            if s[i] == g[i]:
                bull += 1
                s[i] = -1
                g[i] = -1
        for i in range(len(s)):
            if s[i] != -1 and s[i] in g:
                cow += 1
                g[g.index(s[i])] = -1
        return str(bull) + 'A' + str(cow) + 'B'