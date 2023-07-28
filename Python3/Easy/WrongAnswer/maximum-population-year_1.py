class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        population = {}
        for birth, death in logs:
            for year in range(birth, death):
                if year in population:
                    population[year] += 1
                else:
                    population[year] = 1
        return sorted(population.items(), key=lambda x: x[1], reverse=True)[0][0]