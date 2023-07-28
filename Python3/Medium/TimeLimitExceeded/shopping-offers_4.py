class Solution:
    def shoppingOffers(self, price: List[int], special: List[List[int]], needs: List[int]) -> int:
        
        
        def helper(needs):
            res = sum([price[i] * needs[i] for i in range(len(needs))])
            for offer in special:
                tmp = [needs[i] - offer[i] for i in range(len(needs))]
                if min(tmp) >= 0:
                    res = min(res, offer[-1] + helper(tmp))
            return res
        return helper(needs)