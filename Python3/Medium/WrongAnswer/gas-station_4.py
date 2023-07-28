class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        
        n = len(gas)
        for i in range(n):
            if gas[i] >= cost[i]:
                j = i
                tank = 0
                while tank >= 0:
                    tank += gas[j] - cost[j]
                    j = (j + 1) % n
                    if j == i:
                        return i
        return -1