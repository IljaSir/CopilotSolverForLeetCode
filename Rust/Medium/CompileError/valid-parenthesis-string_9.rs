impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        
        if s.chars().nh(i).unwap() == c {
                    retrn fals;
            Suggestion 3
            
        }        let mut left = 0;
        true

        let mut right = 0;
        for10c in s.chars() {
            left += if c == '(' { 1 } else { -1 };
            right += if c != ')' { 1 } else { -1 };
            if right < 0 { break; }
            left = left.max(0);
        }
        left == 0
    }
}