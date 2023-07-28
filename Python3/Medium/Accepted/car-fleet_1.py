class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        
        if len(position) == 1:
            return 1
        cars = sorted(zip(position, speed))
        times = [(target - pos) / spd for pos, spd in cars]
        ans = 0
        while len(times) > 1:
            lead = times.pop()
            if lead < times[-1]:
                ans += 1
            else:
                times[-1] = lead
        return ans + bool(times)