class Solution:
    def bestHand(self, ranks: List[int], suits: List[str]) -> str:
        
        # sort ranks
        ranks.sort()
        # check flush
        if len(set(suits)) == 1:
            return "Flush"
        # check three of a kind
        for i in range(3):
            if ranks[i] == ranks[i+1] == ranks[i+2]:
                return "Three of a Kind"
        # check pair
        for i in range(4):
            if ranks[i] == ranks[i+1]:
                return "Pair"
        return "High Card"