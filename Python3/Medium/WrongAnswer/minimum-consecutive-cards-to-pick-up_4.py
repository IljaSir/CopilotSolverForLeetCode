class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        
        # Solution 1: 2-pointer
        """
        1. Sort cards
        2. 2-pointer
        """
        # n = len(cards)
        # cards.sort()
        # left = 0
        # right = 1
        # res = n
        # while right < n:
        #     if cards[left] == cards[right]:
        #         res = min(res, right - left + 1)
        #         left = right + 1
        #         right = left + 1
        #     else:
        #         right += 1
        # return res if res != n else -1

        # Solution 2: Counter
        """
        1. Count the number of each card
        2. Find the minimum number of cards that need to be picked up to have a pair of matching cards
        """
        c = collections.Counter(cards)
        res = n = len(cards)
        for k, v in c.items():
            if v >= 2:
                res = min(res, n - v)
        return res if res != n else -1