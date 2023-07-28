impl Solution {
    pub fn longest_prefix(s: String) -> String {
        
        let mut kmp = vec![0; s.len()];
        let mut i = 1;
        let mut j = 0;
        let mut chars = s.chars().collect::<Vec<char>>();
        while i < s.len() {
            if chars[i] == chars[j] {
                j += 1;
                kmp[i] = j;
                i += 1;
            } else {
                if j != 0 {
                    j = kmp[j-1];
                } else {
                    i += 1;
                }
            }
        }
        let mut res = String::new();
        if kmp[s.len()-1] > 0 {
            for i in 0..kmp[s.len()-1] {
                res.push(chars[i]);
            }
        }
        return res;
    }
}