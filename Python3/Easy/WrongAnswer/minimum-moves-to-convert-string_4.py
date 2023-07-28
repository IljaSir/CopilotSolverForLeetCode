class Solution:
    def minimumMoves(self, s: str) -> int:
        
        s = list(s)
        n = len(s)
        if n == 3:
            if s[0] == 'X' and s[1] == 'X' and s[2] == 'X':
                return 1
            else:
                return 0
        if n == 4:
            if s[0] == 'X' and s[1] == 'X' and s[2] == 'X':
                return 1 + self.minimumMoves(s[3:])
            else:
                return self.minimumMoves(s[1:])
        else:
            if s[0] == 'X' and s[1] == 'X' and s[2] == 'X':
                return 1 + self.minimumMoves(s[3:])
            else:
                return self.minimumMoves(s[1:])