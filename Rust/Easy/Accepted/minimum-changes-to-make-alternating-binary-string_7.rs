impl Solution {
    pub fn min_operations(s: String) -> i32 {
        
        let mut res = 0;
        let mut c = '0';
        for i in s.chars() {
            if i != c {
                res += 1;
            }
            c = if c == '0' { '1' } else { '0' };
        }
        res.min(s.len() - res) as i32
    }
}