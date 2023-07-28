class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        
        s = sum(count)
        minimum = 256
        maximum = -1
        mean = 0
        median = 0
        mode = 0
        mode_count = 0
        for i in range(256):
            if count[i] > 0:
                minimum = min(minimum, i)
                maximum = max(maximum, i)
                mean += i * count[i]
                if count[i] > mode_count:
                    mode_count = count[i]
                    mode = i
        mean /= s
        if s % 2 == 1:
            k = s // 2 + 1
            for i in range(256):
                k -= count[i]
                if k <= 0:
                    median = i
                    break
        else:
            k = s // 2
            for i in range(256):
                k -= count[i]
                if k < 0:
                    median = i
                    break
                if k == 0:
                    for j in range(i + 1, 256):
                        if count[j] > 0:
                            median = (i + j) / 2
                            break
                    break
        return [minimum, maximum, mean, median, mode]