class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        
        self.board = board
        self.rook = self.find_rook()
        self.pawns = self.find_pawns()
        self.bishops = self.find_bishops()
        self.captures = 0
        self.check_pawns()
        return self.captures