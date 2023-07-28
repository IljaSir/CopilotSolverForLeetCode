impl Solution {
    pub fn min_max_difference(num: i32) -> i32 {
        
        let mut min = num;
        let mut max = num;
        let mut d = 0;
        let mut n = num;
        while n > 0 {
            let t = n % 10;
            n /= 10;
            for i in 0..10 {
                let mut x = num;
                let mut y = 0;
                let mut p = 1;
                while x > 0 {
                    let mut c = x % 10;
                    x /= 10;
                    if c == t {
                        c = i;
                    }
                    y += c * p;
                    p *= 10;
                }
                if y < min {
                    min = y;
                }
                if y > max {
                    max = y;
                }
            }
            d += 1;
        }
        max - min
    }
}