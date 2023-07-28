impl Solution {
    pub fn robot_with_string(s: String) -> String {
        
        let mut t = String::new();
        let mut i = 0;
        let mut j = s.len() - 1;
        while i <= j {
            let mut left = false;
            for k in 0..(j - i + 1) {
                if s.as_bytes()[i + k] < s.as_bytes()[j - k] {
                    left = true;
                    break;
                } else if s.as_bytes()[i + k] > s.as_bytes()[j - k] {
                    left = false;
                    break;
                }
            }
            if left {
                t.push(s.as_bytes()[i] as char);
                i += 1;
            } else {
                t.push(s.as_bytes()[j] as char);
                j -= 1;
            }
        }
        t
    }
}