class Solution:
    def numSplits(self, s: str) -> int:
        
        n = len(s)
        l = [0]*n
        r = [0]*n
        l[0] = 1
        r[-1] = 1
        lset = set()
        rset = set()
        for i in range(1,n):
            lset.add(s[i-1])
            l[i] = len(lset)
        for i in range(n-2,-1,-1):
            rset.add(s[i+1])
            r[i] = len(rset)
        return sum([l[i]==r[i] for i in range(n)])