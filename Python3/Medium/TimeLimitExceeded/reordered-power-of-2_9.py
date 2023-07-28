class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        
        n = str(n)
        def getPermutation(s, n):
            if n == 0:
                return []
            if n == 1:
                return [s]
            res = []
            for i in range(len(s)):
                for j in getPermutation(s[:i] + s[i+1:], n-1):
                    res.append(s[i] + j)
            return res
        for i in getPermutation(n, len(n)):
            if i[0] != '0' and bin(int(i)).count('1') == 1:
                return True
        return False