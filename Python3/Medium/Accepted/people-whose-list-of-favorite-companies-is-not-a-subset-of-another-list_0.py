class Solution:
    def peopleIndexes(self, favoriteCompanies: List[List[str]]) -> List[int]:
        
        favoriteCompanies = [set(x) for x in favoriteCompanies]
        return [i for i, a in enumerate(favoriteCompanies) if not any(a.issubset(b) for j, b in enumerate(favoriteCompanies) if i != j)]