class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        
        # all cards are different
        # if fronts[i] == backs[i], it's a bad card
        # if fronts[i] != backs[i], it's a good card
        # if fronts[i] == fronts[j] and backs[i] == backs[j], it's a bad card
        # if fronts[i] != fronts[j] and backs[i] != backs[j], it's a good card
        # if fronts[i] == backs[j] and backs[i] == fronts[j], it's a bad card
        # if fronts[i] != backs[j] and backs[i] != fronts[j], it's a good card
        # if fronts[i] == fronts[j] and backs[i] != backs[j], it's a good card
        # if fronts[i] != fronts[j] and backs[i] == backs[j], it's a good card
        # if fronts[i] == backs[j] and backs[i] != fronts[j], it's a good card
        # if fronts[i] != backs[j] and backs[i] == fronts[j], it's a good card
        # if fronts[i] == fronts[j] and backs[i] == backs[j], it's a bad card
        # if fronts[i] != fronts[j] and backs[i] != backs[j], it's a good card
        # if fronts[i] == backs[j] and backs[i] == fronts[j], it's a bad card
        # if fronts[i] != backs[j] and backs[i] != fronts[j], it's a good card
        # if fronts[i] == fronts[j] and backs[i] != backs[j], it's a good card
        # if fronts[i] != fronts[j] and backs[i] == backs[j], it's a good card
        # if fronts[i] == backs[j] and backs[i] != fronts[j], it's a good card
        # if fronts[i] != backs[j] and backs[i] == fronts[j], it's a good card
        # if fronts[i] == fronts[j] and backs[i] == backs[j], it's a bad card
        # if fronts[i] != fronts[j] and backs[i] != backs[j], it's a good card
        # if fronts[i] == backs[j] and backs[i] == fronts[j], it's a bad card
        # if fronts