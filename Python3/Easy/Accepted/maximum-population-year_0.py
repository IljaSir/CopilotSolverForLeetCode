class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        years = [0] * 101
        for log in logs:
            years[log[0] - 1950] += 1
            years[log[1] - 1950] -= 1
        max_year = 0
        max_population = 0
        population = 0
        for i in range(101):
            population += years[i]
            if population > max_population:
                max_population = population
                max_year = i
        return max_year + 1950