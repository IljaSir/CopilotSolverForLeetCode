class Solution:
    def binaryGap(self, n: int) -> int:
        
        binary = bin(n)[2:]
        max_distance = 0
        last_one = None
        for i in range(len(binary)):
            if binary[i] == '1':
                if last_one is None:
                    last_one = i
                else:
                    distance = i - last_one
                    max_distance = max(max_distance, distance)
                    last_one = i
        return max_distance