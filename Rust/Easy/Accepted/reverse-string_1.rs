impl Solution {
    pub fn reverse_string(s: &mut Vec<char>) {
        
        let mut i = 0;
        let mut j = s.len() - 1;
        while i < j {
            let tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i += 1;
            j -= 1;
        }
    }
}