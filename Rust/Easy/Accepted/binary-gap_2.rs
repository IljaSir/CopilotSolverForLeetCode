impl Solution {
    pub fn binary_gap(n: i32) -> i32 {
        
        let mut max = 0;
        let mut last = -1;
        for i in 0..32 {
            if (n & (1 << i)) > 0 {
                if last >= 0 {
                    max = max.max(i - last);
                }
                last = i;
            }
        }
        max
    }
}