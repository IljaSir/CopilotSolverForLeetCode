class Solution:
    def nthUglyNumber(self, n: int) -> int:
        
        res = [1]
        i, j, k = 0, 0, 0
        while len(res) < n:
            a, b, c = res[i]*2, res[j]*3, res[k]*5
            m = min(a, b, c)
            if m == a:
                i += 1
            if m == b:
                j += 1
            if m == c:
                k += 1
            res.append(m)
        return res[-1]