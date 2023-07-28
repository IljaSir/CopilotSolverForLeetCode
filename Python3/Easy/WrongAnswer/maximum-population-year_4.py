class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        years = {}
        for log in logs:
            for year in range(log[0], log[1]):
                years[year] = years.get(year, 0) + 1
        max_population = max(years.values())
        for year, population in years.items():
            if population == max_population:
                return year