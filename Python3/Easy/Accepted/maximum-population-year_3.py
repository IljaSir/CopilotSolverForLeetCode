class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        years = [0] * 101
        for birth, death in logs:
            years[birth - 1950] += 1
            years[death - 1950] -= 1
        max_population = 0
        max_population_year = 0
        population = 0
        for year, delta in enumerate(years):
            population += delta
            if population > max_population:
                max_population = population
                max_population_year = year
        return max_population_year + 1950