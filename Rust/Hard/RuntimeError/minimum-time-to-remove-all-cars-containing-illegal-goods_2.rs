impl Solution {
    pub fn minimum_time(s: String) -> i32 {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut i = 0;
        let mut j = s.len() - 1;
        let mut res = 0;
        while i < j {
            if s[i] == '1' {
                res += 1;
                while i < j && s[j] == '1' {
                    j -= 1;
                    res += 1;
                }
                j -= 1;
            } else {
                i += 1;
            }
        }
        if i == j && s[i] == '1' {
            res += 1;
        }
        res
    }
}