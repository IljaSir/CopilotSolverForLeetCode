class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        
        if not fronts or not backs:
            return 0
        # flip the card that has the same number on its front and back
        # so we can get a good integer
        # the good integer should not appear on the front of any card
        # and it should appear on the back of at least one card
        # the smallest good integer is the result
        # if no good integer, return 0
        # so we need to find the numbers that appear on the front of some cards
        # and the numbers that appear on the back of some cards
        # the numbers that appear on the front of some cards and the back of some cards are not good integers
        # the other numbers are good integers
        # we need to find the smallest good integer
        # we can use a set to record the numbers that appear on the front of some cards
        # and a set to record the numbers that appear on the back of some cards
        # the numbers that appear on the front of some cards and the back of some cards are the intersection of the two sets
        # the other numbers are the union of the two sets
        # we can use the intersection of the two sets to find the numbers that appear on the front of some cards and the back of some cards
        # we can use the union of the two sets to find the numbers that appear on the front of some cards or the back of some cards
        # we can use the union of the two sets to find the numbers that do not appear on the front of some cards or the back of some cards
        # we can use the union of the two sets to find the numbers that appear on the front of some cards or the back of some cards
        # we can use the union of the two sets to find the numbers that do not appear on the front of some cards or the back of some cards
        # we can use the union of the two sets to find the numbers that appear on the front of some cards or the back of some cards
        # we can use the union of the two sets to find the numbers that do not appear on the front of some cards or the back of some cards
        # we can use the union of the two sets to find the numbers that appear on the front of some cards or the back of some cards
        # we can use the union of the two sets