class Solution:
    def peopleIndexes(self, favoriteCompanies: List[List[str]]) -> List[int]:
        
        # favoriteCompanies = [sorted(fc) for fc in favoriteCompanies]
        # return [i for i, fc in enumerate(favoriteCompanies) if not any(fc in favoriteCompanies[j] for j in range(len(favoriteCompanies)) if i != j)]
        favoriteCompanies = [set(fc) for fc in favoriteCompanies]
        return [i for i, fc in enumerate(favoriteCompanies) if not any(fc.issubset(favoriteCompanies[j]) for j in range(len(favoriteCompanies)) if i != j)]