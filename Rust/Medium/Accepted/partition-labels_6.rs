impl Solution {
    pub fn partition_labels(s: String) -> Vec<i32> {
        
        let mut ans = vec![];
        let mut last = vec![0; 26];
        let mut start = 0;
        let mut end = 0;
        for (i, ch) in s.bytes().enumerate() {
            last[(ch - b'a') as usize] = i;
        }
        for (i, ch) in s.bytes().enumerate() {
            end = end.max(last[(ch - b'a') as usize]);
            if i == end {
                ans.push((end - start + 1) as i32);
                start = end + 1;
            }
        }
        ans
    }
}