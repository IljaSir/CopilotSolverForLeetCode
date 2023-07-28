class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        
        if sum(gas) < sum(cost):
            return -1
        gas -= cost
        n = len(gas)
        start = 0
        tank = 0
        for i in range(n):
            tank += gas[i]
            if tank < 0:
                start = i + 1
                tank = 0
        return start