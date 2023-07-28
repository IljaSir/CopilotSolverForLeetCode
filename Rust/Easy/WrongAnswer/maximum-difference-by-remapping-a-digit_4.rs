impl Solution {
    pub fn min_max_difference(num: i32) -> i32 {
        
        let mut max = 0;
        let mut min = 0;
        let mut n = num;
        let mut digits = Vec::new();
        while n > 0 {
            digits.push(n % 10);
            n /= 10;
        }
        digits.reverse();
        let mut is_max = true;
        for i in 0..digits.len() {
            let mut d = digits[i];
            if d == 9 && is_max {
                max = max * 10 + 9;
                min = min * 10 + d;
            } else if d == 0 && !is_max {
                min = min * 10;
                max = max * 10 + d;
            } else {
                if is_max {
                    max = max * 10 + 9;
                    min = min * 10 + d;
                    is_max = false;
                } else {
                    min = min * 10;
                    max = max * 10 + d;
                }
            }
        }
        max - min
    }
}