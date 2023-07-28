class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        
        products.sort()
        ans = []
        for i in range(1, len(searchWord)+1):
            ans.append([])
            for p in products:
                if p[:i] == searchWord[:i]:
                    ans[-1].append(p)
                if len(ans[-1]) == 3:
                    break
        return ans