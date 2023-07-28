class Solution:
    def bestHand(self, ranks: List[int], suits: List[str]) -> str:
        
        # 1. Check for Flush
        if len(set(suits)) == 1:
            return "Flush"
        # 2. Check for Three of a Kind
        for i in ranks:
            if ranks.count(i) == 3:
                return "Three of a Kind"
        # 3. Check for Pair
        for i in ranks:
            if ranks.count(i) == 2:
                return "Pair"
        # 4. Check for High Card
        return "High Card"