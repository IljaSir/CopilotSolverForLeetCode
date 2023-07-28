class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        
        dominoes = 'L' + dominoes + 'R'
        ans = ''
        i = 0
        for j in range(1, len(dominoes)):
            if dominoes[j] == '.':
                continue
            mid = j - i - 1
            if i:
                ans += dominoes[i]
            if dominoes[i] == dominoes[j]:
                ans += dominoes[i] * mid
            elif dominoes[i] == 'L' and dominoes[j] == 'R':
                ans += '.' * mid
            else:
                ans += 'R' * (mid//2) + '.' * (mid%2) + 'L' * (mid//2)
            i = j
        return ans