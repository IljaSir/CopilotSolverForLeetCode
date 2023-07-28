class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        
        # get the minimum and maximum
        min_val = 0
        while count[min_val] == 0:
            min_val += 1
        max_val = 255
        while count[max_val] == 0:
            max_val -= 1
        # get the mean
        total = 0
        total_count = 0
        for i in range(256):
            total += i * count[i]
            total_count += count[i]
        mean = total / total_count
        # get the median
        median = 0
        if total_count % 2 == 0:
            # even
            median = total_count // 2
            for i in range(256):
                if count[i] <= median:
                    median -= count[i]
                else:
                    median = i
                    break
            median += 0.5
        else:
            # odd
            median = total_count // 2 + 1
            for i in range(256):
                if count[i] < median:
                    median -= count[i]
                else:
                    median = i
                    break
        # get the mode
        mode = 0
        for i in range(256):
            if count[i] > count[mode]:
                mode = i
        return [min_val, max_val, mean, median, mode]