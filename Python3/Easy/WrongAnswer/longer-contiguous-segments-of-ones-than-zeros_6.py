class Solution:
    def checkZeroOnes(self, s: str) -> bool:
        
        if len(s) == 1:
            if s == '1':
                return True
            else:
                return False
        count = 1
        max_count = 1
        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                count += 1
            else:
                if count > max_count:
                    max_count = count
                count = 1
        if count > max_count:
            max_count = count
        if s[0] == '1':
            count = 1
            max_count_1 = 1
            for i in range(1, len(s)):
                if s[i] == s[i - 1]:
                    count += 1
                else:
                    if count > max_count_1:
                        max_count_1 = count
                    count = 1
            if count > max_count_1:
                max_count_1 = count
            if max_count_1 > max_count:
                return True
            else:
                return False
        else:
            count = 1
            max_count_0 = 1
            for i in range(1, len(s)):
                if s[i] == s[i - 1]:
                    count += 1
                else:
                    if count > max_count_0:
                        max_count_0 = count
                    count = 1
            if count > max_count_0:
                max_count_0 = count
            if max_count_0 > max_count:
                return False
            else:
                return True