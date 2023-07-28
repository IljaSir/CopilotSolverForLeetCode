class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        # 1. sort the array by year
        # 2. keep a counter for each year
        # 3. keep a max counter
        # 4. keep a max year
        # 5. return max year
        # Time  complexity: O(NlogN)
        # Space complexity: O(N)
        logs.sort()
        counter = 0
        max_counter = 0
        max_year = 0
        for year in range(1950, 2050):
            while logs and logs[0][0] <= year:
                counter += 1
                logs.pop(0)
            while logs and logs[0][1] <= year:
                counter -= 1
                logs.pop(0)
            if counter > max_counter:
                max_counter = counter
                max_year = year
        return max_year