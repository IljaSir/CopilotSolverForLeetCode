class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        logs.sort()
        max_pop = 0
        max_year = 0
        for year in range(1950, 2051):
            pop = 0
            for birth, death in logs:
                if year >= birth and year < death:
                    pop += 1
            if pop > max_pop:
                max_pop = pop
                max_year = year
        return max_year