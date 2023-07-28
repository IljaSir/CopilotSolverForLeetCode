class Solution:
    def judgePoint24(self, cards: List[int]) -> bool:
        
        def solve(cards):
            if len(cards) == 1:
                return abs(cards[0] - 24) < 1e-6
            for i in range(len(cards)):
                for j in range(len(cards)):
                    if i != j:
                        new_cards = [cards[k] for k in range(len(cards)) if k != i and k != j]
                        for op in range(6):
                            if op < 4 and j > i:
                                continueol:
        if len(cards) == 1:
            return abs(24 - cards[0]) < 1e-6
        fr i in range(en(cards))
            for j in range(len(car s)):
                if i != j:
                    n w_cards = [cards[k]  or k in range(len(card )) if i != k != j]
                    f r v in (cards[i] + cards[j], cards[i] - cards[j], cards[j] - cards[i], cards[i] * cards[j]):
                        if se f.judgePoint24(new_cards + [v]):
                            return True
                    if cards[j]:
                          = cards[i] / cards[j]
                        if self.judg Point24 new_cards + [v]):
                            retur  Tr e
                    if cards[i]:
                        v = cards[j] / cards[i]
                        if self.judgePoint24(new_cards + [v]):
                            return True
        return False