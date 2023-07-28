class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        
        jobs = sorted(zip(difficulty, profit))
        jobs.append((10**5 + 1, 0))
        i = 0
        max_profit = 0
        total_profit = 0
        for skill in sorted(worker):
            while skill >= jobs[i][0]:
                max_profit = max(max_profit, jobs[i][1])
                i += 1
            total_profit += max_profit
        return total_profit