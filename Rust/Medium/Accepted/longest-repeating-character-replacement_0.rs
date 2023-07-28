impl Solution {
    pub fn character_replacement(s: String, k: i32) -> i32 {
        

        let mut start = 0;
        let mut end = 0;
        let mut max_count = 0;
        let mut counts = vec![0; 26];
        let s = s.as_bytes();
        while end < s.len() {
            counts[(s[end] - b'A') as usize] += 1;
            max_count = max_count.max(counts[(s[end] - b'A') as usize]);
            if end - start + 1 > max_count + k as usize {
                counts[(s[start] - b'A') as usize] -= 1;
                start += 1;
            }
            end += 1;
        }
        (end - start) as i32
    }
}