class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        
        # Minimum
        minimum = 0
        for i in range(len(count)):
            if count[i] != 0:
                minimum = i
                break
        # Maximum
        maximum = 0
        for i in range(len(count)-1, -1, -1):
            if count[i] != 0:
                maximum = i
                break
        # Mean
        mean = 0
        total = 0
        for i in range(len(count)):
            total += count[i] * i
        mean = total / sum(count)
        # Median
        median = 0
        if sum(count) % 2 == 0:
            median = (sum(count) // 2) + 1
        else:
            median = sum(count) // 2 + 1
        temp = 0
        for i in range(len(count)):
            temp += count[i]
            if temp > median:
                median = i
                break
            elif temp == median:
                for j in range(i+1, len(count)):
                    if count[j] != 0:
                        median = (i + j) / 2
                        break
                break
        # Mode
        mode = 0
        max_count = 0
        for i in range(len(count)):
            if count[i] > max_count:
                max_count = count[i]
                mode = i
        return [minimum, maximum, mean, median, mode]