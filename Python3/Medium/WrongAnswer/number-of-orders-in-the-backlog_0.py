class Solution:
    def getNumberOfBacklogOrders(self, orders: List[List[int]]) -> int:
        
        buy_orders = []
        sell_orders = []
        for order in orders:
            if order[2] == 0:
                buy_orders.append(order)
            else:
                sell_orders.append(order)
        buy_orders.sort(key=lambda x: -x[0])
        sell_orders.sort(key=lambda x: x[0])
        while buy_orders and sell_orders:
            buy_order = buy_orders[-1]
            sell_order = sell_orders[-1]
            if buy_order[0] >= sell_order[0]:
                if buy_order[1] == sell_order[1]:
                    buy_orders.pop()
                    sell_orders.pop()
                elif buy_order[1] > sell_order[1]:
                    buy_orders[-1][1] -= sell_order[1]
                    sell_orders.pop()
                else:
                    sell_orders[-1][1] -= buy_order[1]
                    buy_orders.pop()
            else:
                break
        return sum([order[1] for order in buy_orders]) + sum([order[1] for order in sell_orders])