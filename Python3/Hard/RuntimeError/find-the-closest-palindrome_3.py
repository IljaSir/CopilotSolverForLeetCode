class Solution:
    def nearestPalindromic(self, n: str) -> str:
        
        l = len(n)
        if l == 1:
            return str(int(n)-1)
        if l == 2:
            if int(n) == 10:
                return '9'
            else:
                return str(int(n)-1)
        if l == 3:
            if int(n) == 101:
                return '99'
            else:
                return str(int(n)-1)
        if l == 4:
            if int(n) == 1001:
                return '999'
            else:
                return str(int(n)-1)
        if l == 5:
            if int(n) == 10001:
                return '9999'
            else:
                return str(int(n)-1)
        if l == 6:
            if int(n) == 100001:
                return '99999'
            else:
                return str(int(n)-1)
        if l == 7:
            if int(n) == 1000001:
                return '999999'
            else:
                return str(int(n)-1)
        if l == 8:
            if int(n) == 10000001:
                return '9999999'
            else:
                return str(int(n)-1)
        if l == 9:
            if int(n) == 100000001:
                return '99999999'
            else:
                return str(int(n)-1)
        if l == 10:
            if int(n) == 1000000001:
                return '999999999'
            else:
                return str(int(n)-1)
        if l == 11:
            if int(n) == 10000000001:
                return '9999999999'
            else:
                return str(int(n)-1)
        if l == 12:
            if int(n) == 100000000001:
                return '99999999999'
            else:
                return str(int(n)-1)
        if l == 13:
            if int(n) == 1000000000001:
                return '999999999999'
            else:
                return str(int(n)-1)
        if l == 14:
            if int(n) == 10000000000001:
                return '9999999999999'
            else:
                return str(int(n)-1)
        if l == 15:
            if int(n) ==