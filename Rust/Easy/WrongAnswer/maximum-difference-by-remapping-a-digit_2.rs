impl Solution {
    pub fn min_max_difference(num: i32) -> i32 {
        
        let mut min = num;
        let mut max = num;
        let mut n = num;
        let mut digits = Vec::new();
        while n > 0 {
            digits.push(n % 10);
            n /= 10;
        }
        digits.reverse();
        for i in 0..digits.len() {
            for j in 0..10 {
                if digits[i] != j {
                    let mut x = 0;
                    for k in 0..digits.len() {
                        if k == i {
                            x = x * 10 + j;
                        } else {
                            x = x * 10 + digits[k];
                        }
                    }
                    min = min.min(x);
                    max = max.max(x);
                }
            }
        }
        max - min
    }
}