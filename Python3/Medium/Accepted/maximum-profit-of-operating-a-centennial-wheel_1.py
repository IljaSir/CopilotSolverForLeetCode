class Solution:
    def minOperationsMaxProfit(self, customers: List[int], boardingCost: int, runningCost: int) -> int:
        
        
        profit = 0
        max_profit = 0
        max_profit_round = 0
        current_customer = 0
        for i in range(len(customers)):
            current_customer += customers[i]
            if current_customer >= 4:
                profit += 4 * boardingCost - runningCost
                current_customer -= 4
            else:
                profit += current_customer * boardingCost - runningCost
                current_customer = 0
            if profit > max_profit:
                max_profit = profit
                max_profit_round = i + 1
        if current_customer > 0:
            round = 0
            while current_customer > 0:
                if current_customer >= 4:
                    profit += 4 * boardingCost - runningCost
                    current_customer -= 4
                else:
                    profit += current_customer * boardingCost - runningCost
                    current_customer = 0
                round += 1
                if profit > max_profit:
                    max_profit = profit
                    max_profit_round = len(customers) + round
        if max_profit > 0:
            return max_profit_round
        else:
            return -1