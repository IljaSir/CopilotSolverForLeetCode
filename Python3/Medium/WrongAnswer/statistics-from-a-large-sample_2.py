class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        
        # minimum
        min_ = -1
        for i in range(len(count)):
            if count[i] != 0:
                min_ = i
                break
        # maximum
        max_ = -1
        for i in range(len(count)-1, -1, -1):
            if count[i] != 0:
                max_ = i
                break
        # mean
        sum_ = 0
        for i in range(len(count)):
            sum_ += i * count[i]
        mean = sum_ / sum(count)
        # median
        median = -1
        if sum(count) % 2 == 1:
            # odd
            mid = sum(count) // 2
            cnt = 0
            for i in range(len(count)):
                cnt += count[i]
                if cnt > mid:
                    median = i
                    break
        else:
            # even
            mid1 = sum(count) // 2
            mid2 = mid1 - 1
            cnt = 0
            for i in range(len(count)):
                cnt += count[i]
                if cnt > mid1:
                    median = i
                    break
                elif cnt > mid2:
                    median += i
            median /= 2
        # mode
        mode = -1
        max_cnt = -1
        for i in range(len(count)):
            if count[i] > max_cnt:
                mode = i
                max_cnt = count[i]
        return [min_, max_, mean, median, mode]