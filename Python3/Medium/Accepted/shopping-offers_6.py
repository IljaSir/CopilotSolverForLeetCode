class Solution:
    def shoppingOffers(self, price: List[int], special: List[List[int]], needs: List[int]) -> int:
        
        
        def shoppingOffers(price, special, needs, memo):
            if tuple(needs) in memo:
                return memo[tuple(needs)]
            res = sum(p * n for p, n in zip(price, needs))
            for s in special:
                new_needs = [n - s[i] for i, n in enumerate(needs)]
                if min(new_needs) >= 0:
                    res = min(res, s[-1] + shoppingOffers(price, special, new_needs, memo))
            memo[tuple(needs)] = res
            return res
        return shoppingOffers(price, special, needs, {})