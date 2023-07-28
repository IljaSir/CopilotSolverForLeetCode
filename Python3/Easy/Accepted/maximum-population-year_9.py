class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        # 1. find the min year and max year
        # 2. loop the year from min to max, count the population
        # 3. find the max population and the earliest year
        min_year = min([log[0] for log in logs])
        max_year = max([log[1] for log in logs])
        max_population = 0
        max_population_year = 0
        for year in range(min_year, max_year):
            population = 0
            for log in logs:
                if year in range(log[0], log[1]):
                    population += 1
            if population > max_population:
                max_population = population
                max_population_year = year
        return max_population_year