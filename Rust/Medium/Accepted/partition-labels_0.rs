impl Solution {
    pub fn partition_labels(s: String) -> Vec<i32> {
        
        let mut last = [0; 26];
        for (i, c) in s.bytes().enumerate() {
            last[(c - b'a') as usize] = i;
        }
        let mut ans = Vec::new();
        let mut start = 0;
        let mut end = 0;
        for (i, c) in s.bytes().enumerate() {
            end = end.max(last[(c - b'a') as usize]);
            if i == end {
                ans.push((end - start + 1) as i32);
                start = end + 1;
            }
        }
        ans
    }
}