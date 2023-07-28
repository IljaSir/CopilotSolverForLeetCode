class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        
        # sort by birth year
        logs.sort(key=lambda x: x[0])
        max_pop = 0
        max_year = 0
        for i in range(len(logs)):
            # print(logs[i])
            pop = 1
            for j in range(i+1, len(logs)):
                if logs[j][0] <= logs[i][1]:
                    pop += 1
            if pop > max_pop:
                max_pop = pop
                max_year = logs[i][0]
        return max_year