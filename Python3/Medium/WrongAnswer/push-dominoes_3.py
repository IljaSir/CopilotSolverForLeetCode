class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        
        N = len(dominoes)
        forces = [0] * N

        # Populate forces going from left to right
        force = 0
        for i, x in enumerate(dominoes):
            if x == 'R': force = N
            elif x == 'L': force = 0
            else: force = max(force - 1, 0)
            forces[i] += force

        # Populate forces going from right to left
        force = 0
        for i, x in enumerate(dominoes[::-1]):
            if x == 'L': force = N
            elif x == 'R': force = 0
            else: force = max(force - 1, 0)
            forces[~i] -= force

        return "".join('.L'[x > 0] if x else 'R' if x < 0 else '.' for x in forces)