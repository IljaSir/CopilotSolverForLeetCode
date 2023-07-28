class Solution:
    def peopleIndexes(self, favoriteCompanies: List[List[str]]) -> List[int]:
        
        if not favoriteCompanies:
            return []
        if len(favoriteCompanies) == 1:
            return [0]
        favoriteCompanies = [set(company) for company in favoriteCompanies]
        favoriteCompanies.sort(key=len)
        result = []
        for i in range(len(favoriteCompanies)):
            for j in range(i + 1, len(favoriteCompanies)):
                if favoriteCompanies[i].issubset(favoriteCompanies[j]):
                    break
            else:
                result.append(i)
        return result