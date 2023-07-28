class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        
        products.sort()
        result = []
        for i in range(len(searchWord)):
            result.append([])
            for product in products:
                if len(result[i]) < 3 and product.startswith(searchWord[:i+1]):
                    result[i].append(product)
        return result