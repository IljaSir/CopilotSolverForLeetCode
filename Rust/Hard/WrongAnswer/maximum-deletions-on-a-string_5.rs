impl Solution {
    pub fn delete_string(s: String) -> i32 {
        
        let mut res = 0;
        let mut i = 0;
        let mut j = 0;
        let mut s = s.chars().collect::<Vec<char>>();
        while i < s.len() {
            j = i + 1;
            while j < s.len() && s[i] == s[j] {
                j += 1;
            }
            if j - i > 1 {
                res += 1;
                i = j;
            } else {
                i += 1;
            }
        }
        res
    }
}