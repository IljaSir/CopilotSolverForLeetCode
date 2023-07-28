class Solution:
    def bestHand(self, ranks: List[int], suits: List[str]) -> str:
        
        # check if flush
        if len(set(suits)) == 1:
            return "Flush"
        # count the number of each rank
        rank_count = Counter(ranks)
        # check if three of a kind
        if 3 in rank_count.values():
            return "Three of a Kind"
        # check if pair
        if 2 in rank_count.values():
            return "Pair"
        # return high card
        return "High Card"