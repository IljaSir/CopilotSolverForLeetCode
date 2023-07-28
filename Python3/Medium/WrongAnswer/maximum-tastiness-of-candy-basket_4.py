class Solution:
    def maximumTastiness(self, price: List[int], k: int) -> int:
        
        # sort the price
        price.sort()
        # get the maximum tastiness of the k candy
        return sum(price[-k:])