class Solution:
    def executeInstructions(self, n: int, startPos: List[int], s: str) -> List[int]:
        
        def get_max_steps(direction, start, end):
            if direction == 'L' or direction == 'U':
                return start
            else:
                return end - start
        def get_steps(direction, start, end):
            if direction == 'L' or direction == 'U':
                return -1
            else:
                return 1
        max_steps = { 'L': get_max_steps('L', startPos[1], n), 'R': get_max_steps('R', startPos[1], n), 'U': get_max_steps('U', startPos[0], n), 'D': get_max_steps('D', startPos[0], n)}
        steps = { 'L': get_steps('L', startPos[1], n), 'R': get_steps('R', startPos[1], n), 'U': get_steps('U', startPos[0], n), 'D': get_steps('D', startPos[0], n)}
        result = [0 for _ in s]
        for i in range(len(s)):
            result[i] = max_steps[s[i]]
            max_steps[s[i]] = max_steps[s[i]] + steps[s[i]]
        return result