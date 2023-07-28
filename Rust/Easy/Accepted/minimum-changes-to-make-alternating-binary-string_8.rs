impl Solution {
    pub fn min_operations(s: String) -> i32 {
        
        let mut res = 0;
        let mut res2 = 0;
        let mut c = '0';
        let mut c2 = '1';
        for i in s.chars() {
            if i == c {
                res += 1;
            } else {
                res2 += 1;
            }
            c = if c == '0' { '1' } else { '0' };
            c2 = if c2 == '0' { '1' } else { '0' };
        }
        res.min(res2)
    }
}