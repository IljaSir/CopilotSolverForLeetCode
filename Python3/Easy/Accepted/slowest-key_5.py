class Solution:
    def slowestKey(self, releaseTimes: List[int], keysPressed: str) -> str:
        
        max_time = releaseTimes[0]
        max_char = keysPressed[0]
        for i in range(1, len(keysPressed)):
            time = releaseTimes[i] - releaseTimes[i-1]
            if time > max_time or (time == max_time and keysPressed[i] > max_char):
                max_time = time
                max_char = keysPressed[i]
        return max_char