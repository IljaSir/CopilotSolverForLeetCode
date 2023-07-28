impl Solution {
    pub fn check_zero_ones(s: String) -> bool {
        
        let mut max = 0;
        let mut max1 = 0;
        let mut count = 0;
        let mut count1 = 0;
        for i in s.chars() {
            if i == '0' {
                count += 1;
                count1 = 0;
            } else {
                count1 += 1;
                count = 0;
            }
            max = max.max(count);
            max1 = max1.max(count1);
        }
        max1 > max
    }
}