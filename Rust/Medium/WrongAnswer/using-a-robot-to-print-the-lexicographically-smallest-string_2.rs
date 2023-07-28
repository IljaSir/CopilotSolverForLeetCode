impl Solution {
    pub fn robot_with_string(s: String) -> String {
        
        let mut t = String::new();
        let mut i = 0;
        let mut j = s.len() - 1;
        while i <= j {
            let mut k = 0;
            while i + k <= j && s.chars().nth(i + k) == s.chars().nth(j - k) {
                k += 1;
            }
            if i + k > j || s.chars().nth(i + k) < s.chars().nth(j - k) {
                t.push(s.chars().nth(i).unwrap());
                i += 1;
            } else {
                t.push(s.chars().nth(j).unwrap());
                j -= 1;
            }
        }
        t
    }
}