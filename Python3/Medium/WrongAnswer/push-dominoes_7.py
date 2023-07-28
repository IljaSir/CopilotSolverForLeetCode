class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        
        n = len(dominoes)
        d = [c for c in dominoes]
        i = 0
        while i < n:
            if d[i] == '.':
                i += 1
                continue
            if d[i] == 'L':
                j = i-1
                while j >= 0 and d[j] == '.':
                    d[j] = 'L'
                    j -= 1
                i += 1
            elif d[i] == 'R':
                j = i+1
                while j < n and d[j] == '.':
                    d[j] = 'R'
                    j += 1
                if j < n and d[j] == 'L':
                    k = i+1
                    while k < j:
                        d[k] = '.'
                        k += 1
                i = j
        return ''.join(d)