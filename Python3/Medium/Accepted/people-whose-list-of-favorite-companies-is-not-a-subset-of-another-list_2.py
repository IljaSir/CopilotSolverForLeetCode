class Solution:
    def peopleIndexes(self, favoriteCompanies: List[List[str]]) -> List[int]:
        
        favoriteCompanies = [set(x) for x in favoriteCompanies]
        res = []
        for i, x in enumerate(favoriteCompanies):
            if all(not x.issubset(y) for j, y in enumerate(favoriteCompanies) if i != j):
                res.append(i)
        return res