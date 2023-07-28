impl Solution {
    pub fn check_zero_ones(s: String) -> bool {
        
        let mut max1 = 0;
        let mut max0 = 0;
        let mut cur1 = 0;
        let mut cur0 = 0;
        for c in s.chars() {
            if c == '1' {
                cur1 += 1;
                cur0 = 0;
            } else {
                cur0 += 1;
                cur1 = 0;
            }
            max1 = max1.max(cur1);
            max0 = max0.max(cur0);
        }
        max1 > max0
    }
}