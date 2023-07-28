class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        
        # check if there is a solution
        if sum(gas) < sum(cost):
            return -1
        # check if there is a solution
        if sum(gas) < sum(cost):
            return -1
        # initialize the tank to 0
        tank = 0
        # initialize the starting point to 0
        start = 0
        # iterate over the gas stations
        for i in range(len(gas)):
            # update the tank
            tank += gas[i] - cost[i]
            # check if the tank is negative
            if tank < 0:
                # update the starting point
                start = i + 1
                # reset the tank
                tank = 0
        # return the starting point
        return start