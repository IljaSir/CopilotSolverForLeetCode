class Solution:
    def shoppingOffers(self, price: List[int], special: List[List[int]], needs: List[int]) -> int:
        
        
        def dfs(needs):
            res = sum([price[i]*needs[i] for i in range(len(needs))])
            for offer in special:
                new_needs = [needs[i]-offer[i] for i in range(len(needs))]
                if min(new_needs) >= 0:
                    res = min(res, offer[-1]+dfs(new_needs))
            return res
        
        return dfs(needs)