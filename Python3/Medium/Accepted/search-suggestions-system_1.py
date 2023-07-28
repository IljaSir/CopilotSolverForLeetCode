class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        
        products.sort()
        result = []
        for i in range(1, len(searchWord)+1):
            prefix = searchWord[:i]
            result.append([product for product in products if product.startswith(prefix)][:3])
        return result