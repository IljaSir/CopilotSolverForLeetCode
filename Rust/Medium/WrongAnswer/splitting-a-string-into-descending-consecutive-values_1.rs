impl Solution {
    pub fn split_string(s: String) -> bool {
        
        let mut s = s.chars().map(|c| c.to_digit(10).unwrap() as i32).collect::<Vec<i32>>();
        let mut i = 0;
        while i < s.len() - 1 {
            let mut j = i + 1;
            let mut n = s[i];
            while j < s.len() {
                n = n * 10 + s[j];
                if n == s[i] - 1 {
                    s[i] = n;
                    s.remove(j);
                    j -= 1;
                    if i > 0 {
                        i -= 1;
                    }
                }
                j += 1;
            }
            i += 1;
        }
        s.len() == 1
    }
}