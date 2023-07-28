impl Solution {
    pub fn reordered_power_of2(n: i32) -> bool {
        
        let mut n = n;
        let mut digits = vec![];
        while n > 0 {
            digits.push(n % 10);
            n /= 10;
        }
        digits.sort();
        for i in 0..32 {
            let mut power = 1 << i;
            let mut power_digits = vec![];
            while power > 0 {
                power_digits.push(power % 10);
                power /= 10;
            }
            power_digits.sort();
            if power_digits == digits {
                return true;
            }
        }
        false
    }
}