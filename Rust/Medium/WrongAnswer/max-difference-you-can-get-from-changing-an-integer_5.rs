impl Solution {
    pub fn max_diff(num: i32) -> i32 {
        
        let mut a = 0;
        let mut b = 0;
        let mut first = true;
        let mut max = 0;
        let mut min = 10;
        let mut num = num;
        while num > 0 {
            let d = num % 10;
            if first {
                if d != 9 {
                    max = d;
                }
                if d != 1 {
                    min = d;
                }
            } else {
                if d == max {
                    a = a * 10 + 9;
                } else {
                    a = a * 10 + d;
                }
                if d == min {
                    b = b * 10 + 1;
                } else {
                    b = b * 10 + d;
                }
            }
            num /= 10;
        }
        if first {
            a = 9;
            b = 1;
        }
        a - b
    }
}