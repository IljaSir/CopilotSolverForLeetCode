class Solution:
    def getNumberOfBacklogOrders(self, orders: List[List[int]]) -> int:
        
        buy = []
        sell = []
        for price, amount, order_type in orders:
            if order_type:
                while amount and buy and buy[0][0] >= price:
                    curr_price, curr_amount = heapq.heappop(buy)
                    if amount >= curr_amount:
                        amount -= curr_amount
                    else:
                        heapq.heappush(buy, (curr_price, curr_amount - amount))
                        amount = 0
                if amount:
                    heapq.heappush(sell, (price, amount))
            else:
                while amount and sell and sell[0][0] <= price:
                    curr_price, curr_amount = heapq.heappop(sell)
                    if amount >= curr_amount:
                        amount -= curr_amount
                    else:
                        heapq.heappush(sell, (curr_price, curr_amount - amount))
                        amount = 0
                if amount:
                    heapq.heappush(buy, (-price, amount))
        return sum(amount for _, amount in buy + sell) % (10**9 + 7)