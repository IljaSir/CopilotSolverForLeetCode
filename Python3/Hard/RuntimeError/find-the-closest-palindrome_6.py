class Solution:
    def nearestPalindromic(self, n: str) -> str:
        
        l = len(n)
        if l == 1: return str(int(n)-1)
        if n == '9'*l: return str(int(n)+2)
        if n == '1' + '0'*(l-1) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-2) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-3) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-4) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-5) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-6) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-7) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-8) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-9) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-10) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-11) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-12) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-13) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-14) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-15) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-16) + '1': return str(int(n)-2)
        if n == '1' + '0'*(l-17) + '1': return str(int(n)-2)
        if n ==