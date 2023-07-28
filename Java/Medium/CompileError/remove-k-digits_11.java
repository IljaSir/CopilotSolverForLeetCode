class Solution {
    public String removeKdigits(String num, int k) {
        
        if (k == num.length()) {
            return "0";
        }
        // num = "1432219", k = 3
        // 1. 4 > 3, remove 4
        // 2. 3 > 2, remove 3
        // 3. 2 > 2, remove 2
        // 4. 2 < 1, remove 1
        // 5. 2 < 9, remove 9
        // 6. 2 < 2, remove 2
        // 7. 2 < 1, remove 1
        // 8. 2 < 3, remove 3
        // 9. 2 < 4, remove 4
        // 10. 2 < 5, remove 5
        // 11. 2 < 6, remove 6
        // 12. 2 < 7, remove 7
        // 13. 2 < 8, remove 8
        // 14. 2 < 9, remove 9
        // 15. 2 < 0, remove 0
        // 16. 2 < 1, remove 1
        // 17. 2 < 2, remove 2
        // 18. 2 < 3, remove 3
        // 19. 2 < 4, remove 4
        // 20. 2 < 5, remove 5
        // 21. 2 < 6, remove 6
        // 22. 2 < 7, remove 7
        // 23. 2 < 8, remove 8
        // 24. 2 < 9, remove 9
        // 25. 2 < 0, remove 0
        // 26. 2 < 1, remove 1
        // 27. 2 < 2, remove 2
        // 28. 2 < 3, remove 3
        // 29. 2 < 4, remove 4
        // 30. 2 < 5, remove 5
        // 31. 2 < 6, remove 6
        // 32
    }
}