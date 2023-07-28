impl Solution {
    pub fn minimum_time(s: String) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        let mut last = '0';
        for c in s.chars() {
            if c == '1' {
                count += 1;
                if last == '0' {
                    max = count;
                }
            } else {
                count = 0;
            }
            last = c;
        }
        let mut result = 0;
        if max > 0 {
            result = 2 * (max - 1);
            if max < s.len() {
                result += 1;
            }
        }
        result
    }
}