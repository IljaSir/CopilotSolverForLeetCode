class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        
        products.sort()
        ans = []
        for i in range(len(searchWord)):
            ans.append([p for p in products if p.startswith(searchWord[:i+1])][:3])
        return ans