impl Solution {
    pub fn sort_string(s: String) -> String {
        
        let mut result = String::new();
        let mut s = s.chars().collect::<Vec<_>>();
        s.sort();
        let mut i = 0;
        while i < s.len() {
            let mut j = i;
            while j < s.len() && s[j] == s[i] {
                j += 1;
            }
            for k in i..j {
                result.push(s[k]);
            }
            i = j;
        }
        i = s.len();
        while i > 0 {
            let mut j = i;
            while j > 0 && s[j - 1] == s[i - 1] {
                j -= 1;
            }
            for k in (j..i).rev() {
                result.push(s[k]);
            }
            i = j;
        }
        result
    }
}