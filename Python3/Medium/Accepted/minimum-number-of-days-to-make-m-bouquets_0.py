class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        
        if m*k > len(bloomDay):
            return -1
        def can_make_bouquets(days):
            bouquets = flowers = 0
            for bloom in bloomDay:
                if bloom <= days:
                    flowers += 1
                    if flowers == k:
                        bouquets += 1
                        flowers = 0
                else:
                    flowers = 0
            return bouquets >= m
        left, right = 1, max(bloomDay)
        while left < right:
            days = (left + right) // 2
            if can_make_bouquets(days):
                right = days
            else:
                left = days + 1
        return left