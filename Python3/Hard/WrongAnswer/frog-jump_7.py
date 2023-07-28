class Solution:
    def canCross(self, stones: List[int]) -> bool:
        
        if stones[1] > 1:
            return False
        if len(stones) == 2:
            return True
        stones = set(stones)
        last = stones.pop()
        stack = [[0, 1]]
        while stack:
            i, k = stack.pop()
            if i + k == last:
                return True
            if i + k in stones:
                stones.remove(i + k)
                stack.append([i + k, k])
                stack.append([i + k, k + 1])
                if k > 1:
                    stack.append([i + k, k - 1])
        return False