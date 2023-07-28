impl Solution {
    pub fn check_zero_ones(s: String) -> bool {
        
        let mut count = 0;
        let mut max_count = 0;
        let mut max_count_1 = 0;
        let mut prev = ' ';
        for c in s.chars() {
            if prev == ' ' {
                prev = c;
                count = 1;
            } else if prev == c {
                count += 1;
            } else {
                if prev == '1' {
                    max_count_1 = max_count_1.max(count);
                } else {
                    max_count = max_count.max(count);
                }
                prev = c;
                count = 1;
            }
        }
        if prev == '1' {
            max_count_1 = max_count_1.max(count);
        } else {
            max_count = max_count.max(count);
        }
        max_count_1 > max_count
    }
}