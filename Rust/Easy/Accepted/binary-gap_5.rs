impl Solution {
    pub fn binary_gap(n: i32) -> i32 {
        
        let mut pos = -1;
        let mut max = 0;
        for i in 0..32 {
            if n & (1 << i) > 0 {
                if pos >= 0 {
                    max = max.max(i - pos);
                }
                pos = i;
            }
        }
        max
    }
}