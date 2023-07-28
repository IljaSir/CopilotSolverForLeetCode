class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        
        # minimum
        i = 0
        while count[i] == 0:
            i += 1
        minimum = i
        # maximum
        i = len(count) - 1
        while count[i] == 0:
            i -= 1
        maximum = i
        # mean
        mean = 0
        total = 0
        for i in range(len(count)):
            mean += count[i] * i
            total += count[i]
        mean /= total
        # median
        if total % 2 == 1:
            median = 0
            for i in range(len(count)):
                median += count[i]
                if median > total // 2:
                    median = i
                    break
        else:
            median = 0
            for i in range(len(count)):
                median += count[i]
                if median == total // 2:
                    median = i
                    break
                elif median > total // 2:
                    median = (i + median - total // 2) / 2
                    break
        # mode
        mode = 0
        for i in range(len(count)):
            if count[i] > count[mode]:
                mode = i
        return [minimum, maximum, mean, median, mode]