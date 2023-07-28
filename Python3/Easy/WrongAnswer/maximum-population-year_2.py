class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        population = {}
        for log in logs:
            for year in range(log[0], log[1]):
                if year in population:
                    population[year] += 1
                else:
                    population[year] = 1
        max_population = max(population.values())
        for year, pop in population.items():
            if pop == max_population:
                return year