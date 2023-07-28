class Solution:
    def judgePoint24(self, cards: List[int]) -> bool:
        
        if not cards: return False
        if len(cards) == 1: return abs(cards[0] - 24) < 1e-6
        for i in range(len(cards)):
            for j in range(len(cards)):
                if i != j:
                    newCards = [cards[k] for k in range(len(cards)) if k != i and k != j]
                    for k in range(4):
                        if k < 2 and j > i: continue
                        if k == 0:
                            newCards.append(cards[i] + cards[j])
                        elif k == 1:
                            newCards.append(cards[i] * cards[j])
                        elif k == 2:
                            newCards.append(cards[i] - cards[j])
                        else:
                            if cards[j] != 0:
                                newCards.append(cards[i] / cards[j])
                            else:
                                continue
                        if self.judgePoint24(newCards):
                            return True
                        newCards.pop()op()
            return False
        return solve(cards)