impl Solution {
    pub fn number_of_substrings(s: String) -> i32 {
        
        let mut result = 0;
        let mut counts = [0; 3];
        let mut start = 0;
        let mut end = 0;
        let mut found = 0;
        let s = s.as_bytes();
        while end < s.len() {
            let c = s[end] as usize - 'a' as usize;
            if counts[c] == 0 {
                found += 1;
            }
            counts[c] += 1;
            while found == 3 {
                let c = s[start] as usize - 'a' as usize;
                result += s.len() - end;
                counts[c] -= 1;
                if counts[c] == 0 {
                    found -= 1;
                }
                start += 1;
            }
            end += 1;
        }
        result as i32
    }
}