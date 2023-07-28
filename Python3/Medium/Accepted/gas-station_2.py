class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        
        n, start, tank = len(gas), 0, 0
        for i in range(n):
            tank += gas[i] - cost[i]
            if tank < 0:
                start = i + 1
                tank = 0
        if start == n:
            return -1
        for i in range(start):
            tank += gas[i] - cost[i]
            if tank < 0:
                return -1
        return start