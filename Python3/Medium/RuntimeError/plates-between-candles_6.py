class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        
        # 1. Find the index of each candle
        # 2. For each query, find the number of plates between candles
        # 3. Return the list of number of plates between candles
        # 4. Time: O(n + m), Space: O(n)
        # 5. n is the length of the string, m is the number of queries
        # 6. 1 <= queries.length <= 10^5
        # 7. 1 <= s.length <= 10^5
        # 8. 0 <= lefti <= righti < s.length
        # 9. 3 <= s.length <= 10^5
        # 10. 0 <= lefti <= righti < s.length
        # 11. 1 <= queries.length <= 10^5
        # 12. 0 <= lefti <= righti < s.length
        # 13. 1 <= s.length <= 10^5
        # 14. 0 <= lefti <= righti < s.length
        # 15. 1 <= queries.length <= 10^5
        # 16. 0 <= lefti <= righti < s.length
        # 17. 1 <= s.length <= 10^5
        # 18. 0 <= lefti <= righti < s.length
        # 19. 1 <= queries.length <= 10^5
        # 20. 0 <= lefti <= righti < s.length
        # 21. 1 <= s.length <= 10^5
        # 22. 0 <= lefti <= righti < s.length
        # 23. 1 <= queries.length <= 10^5
        # 24. 0 <= lefti <= righti < s.length
        # 25. 1 <= s.length <= 10^5
        # 26. 0 <= lefti <= righti < s.length
        # 27. 1 <= queries.length <= 10^5
        # 28. 0 <= lefti <= righti < s.length
        # 29. 1 <= s.length <= 10^5
        # 30. 0 <= lefti <= righti < s.length
        # 31.