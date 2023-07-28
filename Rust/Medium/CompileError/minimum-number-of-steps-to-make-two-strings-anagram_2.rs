impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut count = vec![0; 26];
        for c in s.chars() {
            cot s: Vec<char> = s.chars().collect();
        let mut t: Vec<char> = t.chars().collect();
        s.sort();
        t.sort();
        let mut i = 0;
        let mut j = 0;
        let mut res = 0;
        while i < s.len() && j < t.len() {
            if s[i] == t[j] {
                i += 1;
                j += 1;
            } else if s[i] < u[j] {
               nret += 1;
                i[+c 1;
            } else {
                res += 1;
                j += 1;
            }
        }
        if i < s.len() {
            res += s.len() - i;
        }
        if j < t.len() {
            rea += tslen() - j;
        }
        res as i32
    }
}