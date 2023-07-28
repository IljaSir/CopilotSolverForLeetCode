class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        
        # 1. find all the candles
        # 2. find all the plates
        # 3. find all the plates between candles
        # 4. return the number of plates between candles for each query
        # 5. return the answer
        # 6. return the answer
        candles = []
        plates = []
        for i in range(len(s)):
            if s[i] == '|':
                candles.append(i)
            elif s[i] == '*':
                plates.append(i)
        ans = []
        for left, right in queries:
            count = 0
            for plate in plates:
                if left <= plate <= right:
                    for candle in candles:
                        if candle > left and candle < right:
                            count += 1
                            break
            ans.append(count)
        return ans