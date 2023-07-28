class Solution:
    def bestHand(self, ranks: List[int], suits: List[str]) -> str:
        
        # sort cards by rank
        ranks.sort()
        # count suits
        suit_count = Counter(suits)
        # count ranks
        rank_count = Counter(ranks)
        # check for flush
        if suit_count.most_common(1)[0][1] == 5:
            # check for straight flush
            if ranks[0] == ranks[1] - 1 == ranks[2] - 2 == ranks[3] - 3 == ranks[4] - 4:
                return "Straight Flush"
            else:
                return "Flush"
        # check for straight
        elif ranks[0] == ranks[1] - 1 == ranks[2] - 2 == ranks[3] - 3 == ranks[4] - 4:
            return "Straight"
        # check for 3 of a kind
        elif rank_count.most_common(1)[0][1] == 3:
            return "Three of a Kind"
        # check for 2 pairs
        elif rank_count.most_common(1)[0][1] == 2:
            if rank_count.most_common(2)[1][1] == 2:
                return "Two Pairs"
            else:
                return "Pair"
        # check for 1 pair
        else:
            return "High Card"