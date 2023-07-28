impl Solution {
    pub fn partition_string(s: String) -> i32 {
        
        let mut last = vec![0; 26];
        for (i, c) in s.as_bytes().iter().enumerate() {
            last[(c - b'a') as usize] = i;
        }
        let mut ans = 0;
        let mut start = 0;
        let mut end = 0;
        for (i, c) in s.as_bytes().iter().enumerate() {
            end = end.max(last[(c - b'a') as usize]);
            if i == end {
                ans += 1;
                start = end + 1;
            }
        }
        ans
    }
}