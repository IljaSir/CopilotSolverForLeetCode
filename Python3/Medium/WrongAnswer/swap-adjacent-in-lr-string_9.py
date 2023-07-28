class Solution:
    def canTransform(self, start: str, end: str) -> bool:
        
        # 1. count the number of L and R
        # 2. if L or R are not equal, return False
        # 3. if L or R are equal, check if they are in the same position
        # 4. if L or R are not in the same position, return False
        # 5. if L or R are in the same position, return True
        start_L = start.count('L')
        start_R = start.count('R')
        end_L = end.count('L')
        end_R = end.count('R')
        if start_L != end_L or start_R != end_R:
            return False
        else:
            for i in range(len(start)):
                if start[i] != 'X' and end[i] != 'X':
                    if start[i] != end[i]:
                        return False
                    else:
                        if start[i] == 'L':
                            if start[i:].count('L') != end[i:].count('L'):
                                return False
                        else:
                            if start[i:].count('R') != end[i:].count('R'):
                                return False
            return True