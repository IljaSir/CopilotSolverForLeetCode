impl Solution {
    pub fn partition_string(s: String) -> i32 {
        
        let mut last = vec![0; 26];
        let mut res = 0;
        let mut start = 0;
        let mut end = 0;
        for (i, ch) in s.chars().enumerate() {
            last[(ch as u8 - b'a') as usize] = i;
        }
        for (i, ch) in s.chars().enumerate() {
            end = end.max(last[(ch as u8 - b'a') as usize]);
            if i == end {
                res += 1;
                start = i + 1;
            }
        }
        res
    }
}