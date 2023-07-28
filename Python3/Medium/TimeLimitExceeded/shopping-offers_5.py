class Solution:
    def shoppingOffers(self, price: List[int], special: List[List[int]], needs: List[int]) -> int:
        
        
        def helper(needs):
            min_price = sum([price[i] * needs[i] for i in range(len(price))])
            for offer in special:
                new_needs = [needs[i] - offer[i] for i in range(len(needs))]
                if min(new_needs) >= 0:
                    min_price = min(min_price, offer[-1] + helper(new_needs))
            return min_price
        
        return helper(needs)