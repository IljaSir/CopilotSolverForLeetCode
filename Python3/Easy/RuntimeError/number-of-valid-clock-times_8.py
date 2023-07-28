class Solution:
    def countTime(self, time: str) -> int:
        
        # 1. number of valid clock times
        # 2. the number of valid clock times that can be created by replacing every ? with a digit from 0 to 9.
        # 3. 00:00 - 23:59
        # 4. The earliest possible time is "00:00" and the latest possible time is "23:59".
        # 5. The digits represented by the ? symbol are unknown, and must be replaced with a digit from 0 to 9.
        # 6. time is a valid string of length 5 in the format "hh:mm".
        # 7. "00" <= hh <= "23"
        # 8. "00" <= mm <= "59"
        # 9. Some of the digits might be replaced with '?' and need to be replaced with digits from 0 to 9.
        # 10. 24 * 60 = 1440 choices.
        # 11. 1 <= time.length <= 5
        # 12. time[i] is a digit or '?'.
        # 13. time is a valid time in the form HH:MM.
        # 14. 00 <= HH <= 23
        # 15. 00 <= MM <= 59
        # 16. 00 <= HH <= 23
        # 17. 00 <= MM <= 59
        # 18. 00 <= HH <= 23
        # 19. 00 <= MM <= 59
        # 20. 00 <= HH <= 23
        # 21. 00 <= MM <= 59
        # 22. 00 <= HH <= 23
        # 23. 00 <= MM <= 59
        # 24. 00 <= HH <= 23
        # 25. 00 <= MM <= 59
        # 26. 00 <= HH <= 23
        # 27. 00 <= MM <= 59
        # 28. 00 <= HH <= 23
        # 29. 00 <= MM <= 59
        # 30. 00 <= HH <= 23
        # 31. 00 <= MM <= 59
        # 32. 00 <= HH <= 23
        # 33