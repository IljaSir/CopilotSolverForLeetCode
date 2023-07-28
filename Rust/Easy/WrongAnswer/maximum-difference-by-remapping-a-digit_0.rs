impl Solution {
    pub fn min_max_difference(num: i32) -> i32 {
        
        let mut digits = Vec::new();
        let mut n = num;
        while n > 0 {
            digits.push(n % 10);
            n /= 10;
        }
        digits.reverse();
        let n = digits.len();
        let mut min = 0;
        let mut max = 0;
        for i in 0..n {
            let mut d = digits[i];
            if d == 9 {
                min = min * 10 + d;
                max = max * 10 + d;
            } else {
                let mut min_ = min * 10 + d;
                let mut max_ = max * 10 + d;
                for j in i+1..n {
                    let d_ = digits[j];
                    if d_ == 9 {
                        min_ = min_ * 10 + d_;
                        max_ = max_ * 10 + d_;
                    } else {
                        min_ = min_ * 10 + if d_ < d { d_ } else { d };
                        max_ = max_ * 10 + if d_ < d { d } else { d_ };
                    }
                }
                for _ in i+1..n {
                    min_ = min_ * 10 + 9;
                    max_ = max_ * 10 + 9;
                }
                min = min_;
                max = max_;
                break;
            }
        }
        max - min
    }
}