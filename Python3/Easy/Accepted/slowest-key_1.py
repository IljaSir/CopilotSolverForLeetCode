class Solution:
    def slowestKey(self, releaseTimes: List[int], keysPressed: str) -> str:
        
        max_time = releaseTimes[0]
        max_key = keysPressed[0]
        for i in range(1, len(releaseTimes)):
            if releaseTimes[i] - releaseTimes[i-1] > max_time:
                max_time = releaseTimes[i] - releaseTimes[i-1]
                max_key = keysPressed[i]
            elif releaseTimes[i] - releaseTimes[i-1] == max_time:
                max_key = max(max_key, keysPressed[i])
        return max_key