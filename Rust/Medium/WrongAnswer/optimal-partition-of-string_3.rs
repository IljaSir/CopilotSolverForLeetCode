impl Solution {
    pub fn partition_string(s: String) -> i32 {
        
        let mut res = 0;
        let mut last = [0; 26];
        for (i, c) in s.char_indices() {
            last[(c as u8 - b'a') as usize] = i;
        }
        let mut start = 0;
        let mut end = 0;
        for (i, c) in s.char_indices() {
            end = end.max(last[(c as u8 - b'a') as usize]);
            if i == end {
                res += 1;
                start = i + 1;
            }
        }
        res
    }
}