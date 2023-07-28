impl Solution {
    pub fn binary_gap(n: i32) -> i32 {
        
        let mut n = n;
        let mut max = 0;
        let mut last = -1;
        let mut i = 0;
        while n > 0 {
            if n % 2 == 1 {
                if last >= 0 {
                    max = max.max(i - last);
                }
                last = i;
            }
            n /= 2;
            i += 1;
        }
        max
    }
}