class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        
        products.sort()
        ans = []
        for i in range(len(searchWord)):
            ans.append([])
            for j in range(len(products)):
                if products[j].startswith(searchWord[:i+1]):
                    ans[i].append(products[j])
                    if len(ans[i]) == 3:
                        break
        return ans