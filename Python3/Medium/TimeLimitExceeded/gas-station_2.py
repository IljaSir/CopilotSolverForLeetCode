class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        
        n = len(gas)
        for i in range(n):
            gas[i] -= cost[i]
        for i in range(n):
            if gas[i] >= 0:
                tank = 0
                for j in range(i, i+n):
                    tank += gas[j%n]
                    if tank < 0:
                        break
                if tank >= 0:
                    return i
        return -1