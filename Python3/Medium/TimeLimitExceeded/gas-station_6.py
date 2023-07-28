class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        
        # if sum(gas) < sum(cost):
        #     return -1
        # for i in range(len(gas)):
        #     if gas[i] < cost[i]:
        #         continue
        #     gas_left = gas[i]
        #     for j in range(len(gas)):
        #         gas_left -= cost[(j+i)%len(gas)]
        #         if gas_left < 0:
        #             break
        #         gas_left += gas[(j+i+1)%len(gas)]
        #     if gas_left >= 0:
        #         return i
        # return -1
        n = len(gas)
        for i in range(n):
            if gas[i] < cost[i]:
                continue
            gas_left = gas[i]
            for j in range(n):
                gas_left -= cost[(j+i)%n]
                if gas_left < 0:
                    break
                gas_left += gas[(j+i+1)%n]
            if gas_left >= 0:
                return i
        return -1