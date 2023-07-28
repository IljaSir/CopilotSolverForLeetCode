impl Solution {
    pub fn partition_string(s: String) -> i32 {
        
        let mut ans = 0;
        let mut last = vec![0; 26];
        for (i, c) in s.bytes().enumerate() {
            last[(c - b'a') as usize] = i;
        }
        let mut start = 0;
        let mut end = 0;
        for (i, c) in s.bytes().enumerate() {
            end = end.max(last[(c - b'a') as usize]);
            if i == end {
                ans += 1;
                start = i + 1;
            }
        }
        ans
    }
}