impl Solution {
    pub fn max_diff(num: i32) -> i32 {
        
        let mut a = 0;
        let mut b = 0;
        let mut x = 0;
        let mut y = 0;
        let mut num = num;
        let mut i = 0;
        while num > 0 {
            let t = num % 10;
            if i == 0 {
                x = t;
                y = t;
            } else {
                if x > t {
                    x = t;
                }
                if y < t {
                    y = t;
                }
            }
            a = a * 10 + y;
            b = b * 10 + x;
            num /= 10;
            i += 1;
        }
        a - b
    }
}