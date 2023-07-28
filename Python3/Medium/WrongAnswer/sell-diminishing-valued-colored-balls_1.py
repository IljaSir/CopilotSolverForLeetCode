class Solution:
    def maxProfit(self, inventory: List[int], orders: int) -> int:
        
        # # 1st attempt: greedy algorithm
        # # Time  complexity: O(n log(n))
        # # Space complexity: O(1)
        # inventory.sort(reverse=True)
        # profit = 0
        # while orders > 0:
        #     if inventory[0] > inventory[1]:
        #         profit += inventory[0]
        #         inventory[0] -= 1
        #         orders -= 1
        #     else:
        #         profit += inventory[1]
        #         inventory[1] -= 1
        #         orders -= 1
        # return profit % (10**9 + 7)

        # 2nd attempt: binary search
        # Time  complexity: O(n log(n))
        # Space complexity: O(1)
        def get_profit(inventory, orders, mid):
            profit = 0
            for ball in inventory:
                if ball >= mid:
                    profit += ball - mid + 1
            return profit

        inventory.sort(reverse=True)
        lo, hi = 0, inventory[0]
        while lo <= hi:
            mid = (lo + hi) // 2
            profit = get_profit(inventory, orders, mid)
            if profit < orders:
                hi = mid - 1
            else:
                lo = mid + 1
        return (sum(inventory) - (lo - 1) * orders) % (10**9 + 7)