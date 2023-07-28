class Solution:
    def movesToStamp(self, stamp: str, target: str) -> List[int]:
        
        # find the first match
        # find the last match
        # if the first match is not at 0, then the first match is the first move
        # if the last match is not at the end, then the last match is the last move
        # if the first match is at 0, then the first move is the first match
        # if the last match is at the end, then the last move is the last match
        # if the first match is at 0 and the last match is at the end, then the first move is the first match and the last move is the last match
        # if the first match is not at 0 and the last match is not at the end, then the first move is the first match and the last move is the last match
        # if the first match is not at 0 and the last match is at the end, then the first move is the first match and the last move is the last match
        # if the first match is at 0 and the last match is not at the end, then the first move is the first match and the last move is the last match
        # if the first match is at 0 and the last match is at the end, then the first move is the first match and the last move is the last match
        # if the first match is not at 0 and the last match is not at the end, then the first move is the first match and the last move is the last match
        # if the first match is not at 0 and the last match is at the end, then the first move is the first match and the last move is the last match
        # if the first match is at 0 and the last match is not at the end, then the first move is the first match and the last move is the last match
        # if the first match is at 0 and the last match is at the end, then the first move is the first match and the last move is the last match
        # if the first match is not at 0 and the last match is not at the end, then the first move is the first match and the last move is the last match
        # if the first match is not at 0 and the last match is at the end, then the first move is the first match and the last move is