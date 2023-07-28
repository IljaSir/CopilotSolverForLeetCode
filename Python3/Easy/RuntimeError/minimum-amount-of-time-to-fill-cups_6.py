class Solution:
    def fillCups(self, amount: List[int]) -> int:
        
        # Two cups: 5 seconds
        # One cup: 3 seconds
        # 1. If we have 1 cup of each, we need 5 seconds
        # 2. If we have 2 cups of one type, we need 3 seconds
        # 3. If we have 2 cups of two types, we need 4 seconds
        # 4. If we have 3 cups of one type, we need 5 seconds
        # 5. If we have 3 cups of two types, we need 6 seconds
        # 6. If we have 3 cups of three types, we need 7 seconds
        # 7. If we have 4 cups of one type, we need 6 seconds
        # 8. If we have 4 cups of two types, we need 7 seconds
        # 9. If we have 4 cups of three types, we need 8 seconds
        # 10. If we have 5 cups of one type, we need 7 seconds
        # 11. If we have 5 cups of two types, we need 8 seconds
        # 12. If we have 5 cups of three types, we need 9 seconds
        # 13. If we have 6 cups of one type, we need 8 seconds
        # 14. If we have 6 cups of two types, we need 9 seconds
        # 15. If we have 6 cups of three types, we need 10 seconds
        # 16. If we have 7 cups of one type, we need 9 seconds
        # 17. If we have 7 cups of two types, we need 10 seconds
        # 18. If we have 7 cups of three types, we need 11 seconds
        # 19. If we have 8 cups of one type, we need 10 seconds
        # 20. If we have 8 cups of two types, we need 11 seconds
        # 21. If we have 8 cups of three types, we need 12 seconds
        # 22. If we have 9 cups of one type, we need 11 seconds
        # 23. If we have 9 cups of two types, we need 12 seconds