class Solution:
    def getNumberOfBacklogOrders(self, orders: List[List[int]]) -> int:
        
        buy = []
        sell = []
        for price, amount, orderType in orders:
            if orderType == 0:
                while sell and sell[0][0] <= price and amount > 0:
                    if sell[0][1] <= amount:
                        amount -= sell[0][1]
                        heapq.heappop(sell)
                    else:
                        sell[0][1] -= amount
                        heapq.heapify(sell)
                        amount = 0
                if amount > 0:
                    heapq.heappush(buy, [-price, amount])
            else:
                while buy and -buy[0][0] >= price and amount > 0:
                    if buy[0][1] <= amount:
                        amount -= buy[0][1]
                        heapq.heappop(buy)
                    else:
                        buy[0][1] -= amount
                        heapq.heapify(buy)
                        amount = 0
                if amount > 0:
                    heapq.heappush(sell, [price, amount])
        return (sum([x[1] for x in buy]) + sum([x[1] for x in sell])) % (10**9 + 7)