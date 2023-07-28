impl Solution {
    pub fn robot_with_string(s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut t = Vec::new();
        let mut ans = String::new();
        loop {
            if s.is_empty() && t.is_empty() {
                break;
            }
            if s.is_empty() {
                ans.push(t.pop().unwrap());
            } else if t.is_empty() {
                t.push(s.remove(0));
            } else {
                if s[0] < t[t.len() - 1] {
                    t.push(s.remove(0));
                } else {
                    ans.push(t.pop().unwrap());
                }
            }
        }
        ans
    }
}