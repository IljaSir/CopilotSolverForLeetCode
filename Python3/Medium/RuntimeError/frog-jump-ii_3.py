class Solution:
    def maxJump(self, stones: List[int]) -> int:
        
        # This function is too slow, it will get Time Limit Exceeded Error
        # The solution is to use DP
        # The idea is to use a dictionary to store the maximum jump distance of each stone
        # The maximum jump distance of the first stone is 0
        # For each stone, we check if the previous stones can jump to it
        # If it can, we update the maximum jump distance of the stone
        # The maximum jump distance is the maximum of the maximum jump distance of the previous stone and the absolute difference between the current stone and the previous stone
        # The maximum jump distance of the last stone is the answer
        max_jump = {stones[0]: 0}
        for stone in stones:
            for prev_stone in stones:
                if prev_stone not in max_jump:
                    continue
                if prev_stone + max_jump[prev_stone] >= stone:
                    max_jump[stone] = max(max_jump[stone], stone - prev_stone) if stone in max_jump else stone - prev_stone
        return max_jump[stones[-1]]