class Solution:
    def peopleIndexes(self, favoriteCompanies: List[List[str]]) -> List[int]:
        
        return [i for i, x in enumerate(favoriteCompanies) if not any(set(x) < set(y) for j, y in enumerate(favoriteCompanies) if i != j)]