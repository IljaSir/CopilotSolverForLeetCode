class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        
        n = len(gas)
        for i in range(n):
            if gas[i] >= cost[i]:
                left = 0
                for j in range(i, n):
                    left += gas[j] - cost[j]
                    if left < 0:
                        break
                if left < 0:
                    continue
                for j in range(i):
                    left += gas[j] - cost[j]
                    if left < 0:
                        break
                if left < 0:
                    continue
                return i
        return -1