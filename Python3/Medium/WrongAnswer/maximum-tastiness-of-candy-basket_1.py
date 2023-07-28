class Solution:
    def maximumTastiness(self, price: List[int], k: int) -> int:
        
        price.sort()
        return sum(price[-k:])-sum(price[:len(price)-k])