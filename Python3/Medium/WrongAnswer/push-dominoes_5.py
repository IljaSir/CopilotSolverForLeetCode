class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        
        dominoes = list(dominoes)
        for i in range(1, len(dominoes)):
            if dominoes[i] == 'L' and dominoes[i-1] == 'R':
                dominoes[i-1] = dominoes[i] = 'X'
        for i in range(len(dominoes)-2, -1, -1):
            if dominoes[i] == 'R' and dominoes[i+1] == 'L':
                dominoes[i+1] = dominoes[i] = 'X'
        for i in range(len(dominoes)):
            if dominoes[i] == 'X':
                dominoes[i] = '.'
        return ''.join(dominoes)