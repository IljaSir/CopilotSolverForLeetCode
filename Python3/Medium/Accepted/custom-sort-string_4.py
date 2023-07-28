class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        order = list(order)
        s = list(s)
        s.sort(key=lambda x: order.index(x) if x in order else 100)
        return ''.join(s)