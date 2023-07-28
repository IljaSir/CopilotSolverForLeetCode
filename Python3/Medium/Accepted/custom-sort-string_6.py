class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        # print(order, s)
        order = list(order)
        s = list(s)
        # print(order, s)
        d = {}
        for i, c in enumerate(order):
            d[c] = i
        s.sort(key = lambda x: d.get(x, 26))
        return ''.join(s)