class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        
        products.sort()
        res = []
        for i in range(1, len(searchWord)+1):
            res.append([])
            for product in products:
                if product.startswith(searchWord[:i]):
                    res[i-1].append(product)
                    if len(res[i-1]) == 3:
                        break
        return res