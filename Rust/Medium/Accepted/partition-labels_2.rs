impl Solution {
    pub fn partition_labels(s: String) -> Vec<i32> {
        
        let mut last = [0; 26];
        let mut res = Vec::new();
        for (i, c) in s.chars().enumerate() {
            last[c as usize - 'a' as usize] = i;
        }
        let mut start = 0;
        let mut end = 0;
        for (i, c) in s.chars().enumerate() {
            end = end.max(last[c as usize - 'a' as usize]);
            if i == end {
                res.push((end - start + 1) as i32);
                start = end + 1;
            }
        }
        res
    }
}