impl Solution {
    pub fn minimum_sum(num: i32) -> i32 {
        
        let mut num = num;
        let mut digits = Vec::new();
        while num > 0 {
            digits.push(num % 10);
            num /= 10;
        }
        digits.sort();
        let mut new1 = 0;
        let mut new2 = 0;
        for i in 0..digits.len() {
            if i < 2 {
                new1 = new1 * 10 + digits[i];
            } else {
                new2 = new2 * 10 + digits[i];
            }
        }
        new1 + new2
    }
}