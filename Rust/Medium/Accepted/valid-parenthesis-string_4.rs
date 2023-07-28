impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        

        let mut max = 0;
        let mut min = 0;
        for c in s.chars() {
            if c == '(' {
                max += 1;
                min += 1;
            } else if c == ')' {
                max -= 1;
                min -= 1;
            } else {
                max += 1;
                min -= 1;
            }
            if max < 0 {
                return false;
            }
            min = std::cmp::max(min, 0);
        }
        min == 0
    }
}