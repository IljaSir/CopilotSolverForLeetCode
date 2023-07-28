impl Solution {
    pub fn count_homogenous(s: String) -> i32 {
        
        let mut count = 0;
        let mut last = ' ';
        let mut len = 0;
        for c in s.chars() {
            if c == last {
                len += 1;
            } else {
                last = c;
                len = 1;
            }
            count += len;
        }
        (count % 1000000007) as i32
    }
}