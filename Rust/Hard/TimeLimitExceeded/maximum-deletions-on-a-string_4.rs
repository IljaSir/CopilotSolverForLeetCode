impl Solution {
    pub fn delete_string(s: String) -> i32 {
        
        let mut s = s;
        let mut count = 0;
        while !s.is_empty() {
            let mut i = 0;
            let mut j = 0;
            while j < s.len() {
                if s.as_bytes()[i] == s.as_bytes()[j] {
                    j += 1;
                } else {
                    i = j;
                }
            }
            count += 1;
            s = s.split_off(i);
        }
        count
    }
}