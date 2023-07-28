class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        
        # 1) Create a dictionary
        # 2) Loop through cards
        # 3) If card is in dictionary, return the difference between the index of the card and the index of the dictionary value
        # 4) Else, add the card to the dictionary with the index as the value
        card_dict = {}
        for i, card in enumerate(cards):
            if card in card_dict:
                return i - card_dict[card]
            else:
                card_dict[card] = i
        return -1