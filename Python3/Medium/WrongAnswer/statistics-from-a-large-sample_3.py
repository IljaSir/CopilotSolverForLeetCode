class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        
        minimum = 255
        maximum = 0
        mean = 0
        median = 0
        mode = 0
        mode_count = 0
        total_count = sum(count)
        for i in range(256):
            if count[i] > 0:
                minimum = min(minimum, i)
                maximum = max(maximum, i)
                mean += i * count[i]
                if count[i] > mode_count:
                    mode_count = count[i]
                    mode = i
        mean /= total_count
        count_sum = 0
        for i in range(256):
            count_sum += count[i]
            if count_sum > total_count // 2:
                median = i
                break
            elif count_sum == total_count // 2:
                for j in range(i + 1, 256):
                    if count[j] > 0:
                        median = (i + j) / 2
                        break
                break
        return [minimum, maximum, mean, median, mode]