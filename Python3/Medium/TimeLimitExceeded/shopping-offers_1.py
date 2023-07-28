class Solution:
    def shoppingOffers(self, price: List[int], special: List[List[int]], needs: List[int]) -> int:
        
        
        def dfs(needs):
            res = sum(needs[i]*price[i] for i in range(len(needs)))
            for s in special:
                tmp = [needs[i]-s[i] for i in range(len(needs))]
                if min(tmp) >= 0:
                    res = min(res, s[-1]+dfs(tmp))
            return res
        return dfs(needs)