class Solution:
    def shoppingOffers(self, price: List[int], special: List[List[int]], needs: List[int]) -> int:
        
        
        def dfs(needs):
            res = sum(needs[i] * price[i] for i in range(len(needs)))
            for s in special:
                tmp = needs[:]
                for i in range(len(needs)):
                    if tmp[i] < s[i]:
                        break
                    tmp[i] -= s[i]
                else:
                    res = min(res, dfs(tmp) + s[-1])
            return res
        
        return dfs(needs)