class Solution:
    def getNumberOfBacklogOrders(self, orders: List[List[int]]) -> int:
        
        buy = []
        sell = []
        for price, amount, orderType in orders:
            if orderType == 0:
                while amount > 0 and sell and sell[-1][0] <= price:
                    if sell[-1][1] <= amount:
                        amount -= sell[-1][1]
                        sell.pop()
                    else:
                        sell[-1][1] -= amount
                        amount = 0
                if amount:
                    buy.append([price, amount])
            else:
                while amount > 0 and buy and buy[-1][0] >= price:
                    if buy[-1][1] <= amount:
                        amount -= buy[-1][1]
                        buy.pop()
                    else:
                        buy[-1][1] -= amount
                        amount = 0
                if amount:
                    sell.append([price, amount])
        return (sum(x[1] for x in buy) + sum(x[1] for x in sell)) % (10**9 + 7)