impl Solution {
    pub fn partition_labels(s: String) -> Vec<i32> {
        
        let mut last = vec![0; 26];
        let mut ret = vec![];
        let mut start = 0;
        let mut end = 0;
        for (i, c) in s.chars().enumerate() {
            last[(c as u8 - b'a') as usize] = i;
        }
        for (i, c) in s.chars().enumerate() {
            end = end.max(last[(c as u8 - b'a') as usize]);
            if i == end {
                ret.push((end - start + 1) as i32);
                start = end + 1;
            }
        }
        ret
    }
}