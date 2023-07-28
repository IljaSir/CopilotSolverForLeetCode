impl Solution {
    pub fn check_zero_ones(s: String) -> bool {
        
        let mut max0 = 0;
        let mut max1 = 0;
        let mut count0 = 0;
        let mut count1 = 0;
        for c in s.chars() {
            if c == '0' {
                count0 += 1;
                count1 = 0;
            } else {
                count1 += 1;
                count0 = 0;
            }
            max0 = max0.max(count0);
            max1 = max1.max(count1);
        }
        max1 > max0
    }
}