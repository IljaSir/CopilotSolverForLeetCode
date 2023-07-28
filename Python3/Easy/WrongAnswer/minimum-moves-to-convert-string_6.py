class Solution:
    def minimumMoves(self, s: str) -> int:
        
        # 1. Get all indices of X
        # 2. Get all indices of X that are consecutive
        # 3. Count the number of groups
        # 4. Return the number of groups
        # 1. Get all indices of X
        indices = []
        for i, char in enumerate(s):
            if char == 'X':
                indices.append(i)
        # 2. Get all indices of X that are consecutive
        groups = []
        for i in range(len(indices)):
            if i == 0:
                groups.append([indices[i]])
            else:
                if indices[i] - indices[i-1] == 1:
                    groups[-1].append(indices[i])
                else:
                    groups.append([indices[i]])
        # 3. Count the number of groups
        return len(groups)