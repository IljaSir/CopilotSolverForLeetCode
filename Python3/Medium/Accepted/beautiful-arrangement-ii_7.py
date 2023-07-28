class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        
        res = []
        l = 1
        r = n
        while l <= r:
            if k > 1:
                if k % 2 == 0:
                    res.append(r)
                    r -= 1
                else:
                    res.append(l)
                    l += 1
                k -= 1
            else:
                res.append(l)
                l += 1
        return res