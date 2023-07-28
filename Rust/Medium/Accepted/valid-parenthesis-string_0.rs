impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        

        let mut lo = 0;
        let mut hi = 0;
        for c in s.chars() {
            lo += if c == '(' { 1 } else { -1 };
            hi += if c != ')' { 1 } else { -1 };
            if hi < 0 { break; }
            lo = std::cmp::max(lo, 0);
        }
        lo == 0
    }
}