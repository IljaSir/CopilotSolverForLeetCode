class Solution:
    def slowestKey(self, releaseTimes: List[int], keysPressed: str) -> str:
        
        max_time = 0
        max_key = None
        for i, key in enumerate(keysPressed):
            time = releaseTimes[i] - (releaseTimes[i-1] if i > 0 else 0)
            if time > max_time:
                max_time = time
                max_key = key
            elif time == max_time:
                max_key = max(max_key, key)
        return max_key