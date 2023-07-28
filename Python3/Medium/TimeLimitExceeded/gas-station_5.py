class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        
        n = len(gas)
        for i in range(n):
            if gas[i] >= cost[i]:
                tank = gas[i] - cost[i]
                for j in range(1,n):
                    k = (i+j)%n
                    tank += gas[k] - cost[k]
                    if tank < 0:
                        break
                if tank >= 0:
                    return i
        return -1