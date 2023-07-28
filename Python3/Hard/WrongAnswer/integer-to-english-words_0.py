class Solution:
    def numberToWords(self, num: int) -> str:
        
        if num == 0:
            return "Zero"
        units = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        thousands = ["", "Thousand", "Million", "Billion"]
        def helper(n):
            if n == 0:
                return []
            elif n < 20:
                return [units[n]]
            elif n < 100:
                return [tens[n // 10]] + helper(n % 10)
            else:
                return [units[n // 100]] + ["Hundred"] + helper(n % 100)
        ans = []
        for i, v in enumerate(str(num)[::-1]):
            if v != "0":
                ans += helper(int(v) * 10**i)
                ans.append(thousands[i // 3])
        return " ".join(ans[::-1])