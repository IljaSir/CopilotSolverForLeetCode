class Solution:
    def shoppingOffers(self, price: List[int], special: List[List[int]], needs: List[int]) -> int:
        
        
        def shopping(price, special, needs):
            #print(price, special, needs)
            if not special:
                return sum([price[i] * needs[i] for i in range(len(needs))])
            if not needs:
                return 0
            if sum(needs) == 0:
                return 0
            res = sum([price[i] * needs[i] for i in range(len(needs))])
            for sp in special:
                if sp[-1] >= res:
                    continue
                new_needs = [needs[i] - sp[i] for i in range(len(needs))]
                if all([n >= 0 for n in new_needs]):
                    res = min(res, sp[-1] + shopping(price, special, new_needs))
            return res
        return shopping(price, special, needs)