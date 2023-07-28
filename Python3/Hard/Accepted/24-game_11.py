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
                                continue
                            if op == 0:
                                new_cards.append(cards[i] + cards[j])
                            elif op == 1:
                                new_cards.append(cards[i] - cards[j])
                            elif op == 2:
                                new_cards.append(cards[i] * cards[j])
                            elif op == 3:
                                if cards[j] != 0:
                                    new_cards.append(cards[i] / cards[j])
                                else:
                                    continue
                            elif op == 4:
                                new_cards.append(cards[j] - cards[i])
                            elif op == 5:
                                if cards[i] != 0:
                                    new_cards.append(cards[j] / cards[i])
                                else:
                                    continue
                            if solve(new_cards):
                                return True
                            new_cards.pop()
            return False
        return solve(cards)