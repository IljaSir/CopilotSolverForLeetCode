class Solution:
    def bestHand(self, ranks: List[int], suits: List[str]) -> str:
        
        def isFlush():
            return len(set(suits)) == 1
        def isThreeOfAKind():
            return 3 in collections.Counter(ranks).values()
        def isPair():
            return 2 in collections.Counter(ranks).values()
        if isFlush():
            return "Flush"
        if isThreeOfAKind():
            return "Three of a Kind"
        if isPair():
            return "Pair"
        return "High Card"