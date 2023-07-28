impl Solution {
    pub fn character_replacement(s: String, k: i32) -> i32 {
        

        let mut a = s.as_bytes();
        let mut b = vec![0; 26];
        let mut i = 0;
        let mut j = 0;
        let mut max_cnt = 0;
        while j < a.len() {
            b[(a[j] - b'A') as usize] += 1;
            max_cnt = max_cnt.max(b[(a[j] - b'A') as usize]);
            if j - i + 1 - max_cnt > k as usize {
                b[(a[i] - b'A') as usize] -= 1;
                i += 1;
            }
            j += 1;
        }
        j - i as usize as i32
    }
}