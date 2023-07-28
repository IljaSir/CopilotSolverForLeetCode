impl Solution {
    pub fn minimum_sum(num: i32) -> i32 {
        
        let mut digits = Vec::new();
        let mut n = num;
        while n > 0 {
            digits.push(n % 10);
            n /= 10;
        }
        digits.reverse();
        let mut sum = 0;
        for i in 0..4 {
            let mut new1 = 0;
            for j in 0..i {
                new1 = new1 * 10 + digits[j];
            }
            let mut new2 = 0;
            for j in i..4 {
                new2 = new2 * 10 + digits[j];
            }
            sum = sum.max(new1 + new2);
        }
        sum
    }
}