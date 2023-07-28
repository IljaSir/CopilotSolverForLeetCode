class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        
        # 1. min
        min_ = 0
        for i in range(len(count)):
            if count[i] > 0:
                min_ = i
                break
        # 2. max
        max_ = 0
        for i in range(len(count)-1, -1, -1):
            if count[i] > 0:
                max_ = i
                break
        # 3. mean
        mean = 0
        total = 0
        for i in range(len(count)):
            mean += i * count[i]
            total += count[i]
        mean /= total
        # 4. median
        median = 0
        if total % 2 == 0:
            # even
            median = (total // 2) + 1
            median_index = 0
            for i in range(len(count)):
                median_index += count[i]
                if median_index >= median:
                    median = i
                    break
                if median_index + 1 == median:
                    median = (median + i + 1) / 2
                    break
        else:
            # odd
            median = (total // 2) + 1
            median_index = 0
            for i in range(len(count)):
                median_index += count[i]
                if median_index >= median:
                    median = i
                    break
        # 5. mode
        mode = 0
        max_count = 0
        for i in range(len(count)):
            if count[i] > max_count:
                max_count = count[i]
                mode = i
        return [min_, max_, mean, median, mode]