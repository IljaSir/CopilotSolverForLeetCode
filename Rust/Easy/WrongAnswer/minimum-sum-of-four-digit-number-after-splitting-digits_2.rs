impl Solution {
    pub fn minimum_sum(num: i32) -> i32 {
        
        let mut num = num;
        let mut digits = Vec::new();
        while num > 0 {
            digits.push(num % 10);
            num /= 10;
        }
        digits.reverse();
        let mut min = 10000;
        for i in 1..4 {
            let mut sum = 0;
            for j in 0..4 {
                if j < i {
                    sum = sum * 10 + digits[j];
                } else {
                    sum += digits[j];
                }
            }
            min = min.min(sum);
        }
        min
    }
}