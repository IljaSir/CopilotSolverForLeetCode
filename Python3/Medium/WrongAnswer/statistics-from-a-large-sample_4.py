class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        
        # minimum
        min_val = -1
        for i, v in enumerate(count):
            if v > 0:
                min_val = i
                break

        # maximum
        max_val = -1
        for i in range(len(count)-1, -1, -1):
            if count[i] > 0:
                max_val = i
                break

        # mean
        total = 0
        total_count = 0
        for i, v in enumerate(count):
            total += i * v
            total_count += v
        mean_val = total / total_count

        # median
        median_val = 0
        median_count = 0
        for i, v in enumerate(count):
            median_count += v
            if median_count >= total_count // 2 + 1:
                median_val = i
                break
            elif median_count == total_count // 2:
                median_val = (median_val + i) / 2

        # mode
        mode_val = 0
        mode_count = 0
        for i, v in enumerate(count):
            if v > mode_count:
                mode_val = i
                mode_count = v

        return [min_val, max_val, mean_val, median_val, mode_val]