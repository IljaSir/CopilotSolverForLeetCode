class Solution:
    def bestHand(self, ranks: List[int], suits: List[str]) -> str:
        
        if len(set(suits)) == 1:
            return "Flush"
        elif len(set(ranks)) == 3:
            if ranks.count(ranks[0]) == 2:
                return "Pair"
            else:
                return "Three of a Kind"
        else:
            return "High Card"