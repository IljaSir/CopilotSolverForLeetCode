class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        # Time  complexity: O(N)
        # Space complexity: O(1)
        pop = [0] * 101
        for birth, death in logs:
            pop[birth - 1950] += 1
            pop[death - 1950] -= 1
        max_pop, max_year = 0, 0
        for year, delta in enumerate(pop):
            max_pop += delta
            if max_pop > max_year:
                max_year = max_pop
                ans = year
        return ans + 1950