impl Solution {
    pub fn binary_gap(n: i32) -> i32 {
        
        let mut max = 0;
        let mut last = -1;
        let mut n = n;
        for i in 0..32 {
            if n & 1 == 1 {
                if last != -1 && i - last > max {
                    max = i - last;
                }
                last = i;
            }
            n >>= 1;
        }
        max
    }
}