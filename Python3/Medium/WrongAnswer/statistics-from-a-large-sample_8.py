class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        
        # 1. minimum
        # 2. maximum
        # 3. mean
        # 4. median
        # 5. mode
        # 6. sum
        total = sum(count)
        minimum = 0
        maximum = 0
        mean = 0
        median = 0
        mode = 0
        mode_count = 0
        for i in range(256):
            if count[i] > 0:
                if minimum == 0:
                    minimum = i
                maximum = i
                mean += i * count[i]
                if count[i] > mode_count:
                    mode_count = count[i]
                    mode = i
        mean /= total
        median_count = 0
        for i in range(256):
            median_count += count[i]
            if median_count >= (total + 1) // 2:
                median = i
                break
            if median_count == (total + 1) // 2:
                for j in range(i + 1, 256):
                    if count[j] > 0:
                        median = (i + j) / 2
                        break
                break
        return [minimum, maximum, mean, median, mode]