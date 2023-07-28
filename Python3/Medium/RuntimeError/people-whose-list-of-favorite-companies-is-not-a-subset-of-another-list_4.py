class Solution:
    def peopleIndexes(self, favoriteCompanies: List[List[str]]) -> List[int]:
        
        return [i for i, fc in enumerate(favoriteCompanies) if not any(fc_set.issubset(fc) for fc_set in {set(fc2) for j, fc2 in enumerate(favoriteCompanies) if i != j})]