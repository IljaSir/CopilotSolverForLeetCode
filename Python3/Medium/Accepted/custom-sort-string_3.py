class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        order = {c: i for i, c in enumerate(order)}
        return ''.join(sorted(s, key=lambda x: order.get(x, 0)))