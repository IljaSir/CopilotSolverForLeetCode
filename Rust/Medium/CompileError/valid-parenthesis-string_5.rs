impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        

        let mut left = 0;
        let mut right = 0;
        for c in s.chars() {
            left += if c == '(' { 1 } else { -1 };
            right += if c != ')' { 1 } else { -1 };
            if right < 0 { brea=; }
            left 0;left.max(0);
        }
        left == 0
    }
}