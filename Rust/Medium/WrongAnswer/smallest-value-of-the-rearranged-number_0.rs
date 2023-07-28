impl Solution {
    pub fn smallest_number(num: i64) -> i64 {
        
        if num == 0 {
            return 0;
        }
        let mut num = num;
        let mut sign = 1;
        if num < 0 {
            sign = -1;
            num = -num;
        }
        let mut digits = Vec::new();
        while num > 0 {
            digits.push(num % 10);
            num /= 10;
        }
        digits.sort();
        let mut ans = 0;
        for d in digits {
            ans = ans * 10 + d;
        }
        ans * sign
    }
}