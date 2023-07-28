impl Solution {
    pub fn maximum69_number (num: i32) -> i32 {
        
        let mut n = num;
        let mut max = n;
        let mut i = 0;
        while n > 0 {
            let mut t = n;
            let mut j = 0;
            while t > 0 {
                let d = t % 10;
                if j == i {
                    if d == 6 {
                        t = t + 3;
                    }
                }
                j += 1;
                t = t / 10;
            }
            if t > max {
                max = t;
            }
            i += 1;
            n = n / 10;
        }
        max
    }
}