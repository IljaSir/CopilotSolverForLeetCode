class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        
        products.sort()
        result = []
        for i in range(len(searchWord)):
            result.append([])
            for j in range(len(products)):
                if products[j].startswith(searchWord[:i+1]):
                    result[i].append(products[j])
                if len(result[i]) == 3:
                    break
        return result