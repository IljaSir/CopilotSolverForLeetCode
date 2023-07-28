class Solution:
    def peopleIndexes(self, favoriteCompanies: List[List[str]]) -> List[int]:
        
        result = []
        for i, favs in enumerate(favoriteCompanies):
            is_subset = False
            for j, favs2 in enumerate(favoriteCompanies):
                if i == j:
                    continue
                if set(favs).issubset(set(favs2)):
                    is_subset = True
                    break
            if not is_subset:
                result.append(i)
        return result