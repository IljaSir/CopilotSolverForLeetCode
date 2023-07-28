class Solution:
    def minNumberOfFrogs(self, croakOfFrogs: str) -> int:
        
        
        # 1. Count the number of c, r, o, a, k
        # 2. If there is a k, we need to find the first c, r, o, a that is not paired
        # 3. If there is no k, return -1
        # 4. If there is a c, we need to find the first r, o, a, k that is not paired
        # 5. If there is no c, return -1
        # 6. If there is a r, we need to find the first o, a, k that is not paired
        # 7. If there is no r, return -1
        # 8. If there is a o, we need to find the first a, k that is not paired
        # 9. If there is no o, return -1
        # 10. If there is an a, we need to find the first k that is not paired
        # 11. If there is no a, return -1
        # 12. If there is a k, we need to find the first c that is not paired
        # 13. If there is no k, return -1
        # 14. If there is no c, r, o, a, k, return -1
        # 15. If there is a c, r, o, a, k, return 1
        # 16. If there is more than one c, r, o, a, k, return the number of c, r, o, a, k
        
        # 1. Count the number of c, r, o, a, k
        count_c = 0
        count_r = 0
        count_o = 0
        count_a = 0
        count_k = 0
        for char in croakOfFrogs:
            if char == 'c':
                count_c += 1
            elif char == 'r':
                count_r += 1
            elif char == 'o':
                count_o += 1
            elif char == 'a':
                count_a += 1
            elif char == 'k':
                count_k += 1
        # 2. If there is a k, we need to find the first