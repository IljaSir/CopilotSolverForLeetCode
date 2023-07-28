class Solution:
    def reachNumber(self, target: int) -> int:
        
        target = abs(target)
        step = 0
        sum = 0
        while sum < target:
            step += 1
            sum += step
        if (sum - target) % 2 == 0:
            return step
        else:
            return step + 1 + step % 2