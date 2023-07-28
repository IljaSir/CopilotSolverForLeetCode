impl Solution {
    pub fn min_remove_to_make_valid(s: String) -> String {
        
        let mut left = 0;
        let mut right = 0;
        let mut s: Vec<char> = s.chars().collect();
        for i in 0..s.len() {
            if s[i] == '(' {
                left += 1;
            } else if s[i] == ')' {
                if left > 0 {
                    left -= 1;
                } else {
                    right += 1;
                }
            }
        }
        let mut res = String::new();
        for i in 0..s.len() {
            if s[i] == '(' {
                if left > 0 {
                    res.push(s[i]);
                    left -= 1;
                }
            } else if s[i] == ')' {
                if right > 0 {
                    right -= 1;
                } else {
                    res.push(s[i]);
                }
            } else {
                res.push(s[i]);
            }
        }
        res
    }
}