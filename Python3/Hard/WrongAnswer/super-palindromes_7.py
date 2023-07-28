class Solution:
    def superpalindromesInRange(self, left: str, right: str) -> int:
        
        def isPalindrome(num):
            num = str(num)
            for i in range(len(num)//2):
                if num[i] != num[-i-1]:
                    return False
            return True
        
        def generatePalindromes(num):
            if num == 0:
                return ['0']
            if num == 1:
                return [str(i) for i in range(10)]
            if num == 2:
                return [str(i)+str(i) for i in range(10)]
            if num == 3:
                return [str(i)+str(i)+str(i) for i in range(10)]
            if num % 2 == 0:
                half = generatePalindromes(num//2)
                return [i+j for i in half for j in half]
            else:
                half = generatePalindromes(num//2)
                return [i+str(j)+i for i in half for j in range(10)]
        
        def generateSuperPalindromes(num):
            if num == 1:
                return [str(i) for i in range(10)]
            if num == 2:
                return [str(i)+str(i) for i in range(10)]
            if num == 3:
                return [str(i)+str(i)+str(i) for i in range(10)]
            if num % 2 == 0:
                half = generatePalindromes(num//2)
                return [i+j for i in half for j in half if isPalindrome(int(i+j)**2)]
            else:
                half = generatePalindromes(num//2)
                return [i+str(j)+i for i in half for j in range(10) if isPalindrome(int(i+str(j)+i)**2)]
        
        left_len = len(left)
        right_len = len(right)
        ans = 0
        for i in range(left_len, right_len+1):
            sp = generateSuperPalindromes(i)
            for j in sp:
                if left <= j <= right:
                    ans += 1
        return ans