impl Solution {
    pub fn sort_string(s: String) -> String {
        
        let mut s: Vec<char> = s.chars().collect();
        s.sort();
        let mut ret = String::new();
        loop {
            let mut i = 0;
            while i < s.len() {
                ret.push(s[i]);
                s.remove(i);
            }
            if s.len() == 0 {
                break;
            }
            i = s.len() - 1;
            while i > 0 {
                ret.push(s[i]);
                s.remove(i);
                i -= 1;
            }
            if s.len() == 0 {
                break;
            }
        }
        ret
    }
}