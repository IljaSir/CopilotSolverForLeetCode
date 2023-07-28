class Solution:
    def judgePoint24(self, cards: List[int]) -> bool:
        
        def solve(nu        if op == 0:
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