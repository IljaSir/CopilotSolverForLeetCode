impl Solution {
    pub fn delete_string(s: String) -> i32 {
        
        let mut i = 0;
        let mut j = s.len() - 1;
        let mut count = 0;
        let mut s = s.chars().collect::<Vec<char>>();
        while i < j {
            if s[i] == s[j] {
                let mut k = 1;
                while i + k < j && s[i + k] == s[j - k] {
                    k += 1;
                }
                i += k;
                j -= k;
                count += 2;
            } else {
                return count;
            }
        }
        if i == j {
            count += 1;
        }
        count
    }
}