impl Solution {
    pub fn seconds_to_remove_occurrences(s: String) -> i32 {
        
        let mut c = 0;
        let mut a = 0;
        for i in s.chars() {
            if i == '1' {
                if a > 0 {
                    c += 1;
                    a -= 1;
                } else {
                    a += 1;
                }
            } else {
                if a > 0 {
                    a -= 1;
                } else {
                    c += 1;
                    a += 1;
                }
            }
        }
        c
    }
}