impl Solution {
    pub fn can_construct(s: String, k: i32) -> bool {
        
        let s = s.as_bytes();
        let mut cnt = vec![0; 26];
        for &c in s {
            cnt[(c - b'a') as usize] += 1;
        }
        let mut odd = 0;
        for &c in &cnt {
            if c % 2 == 1 {
                odd += 1;
            }
        }
        odd <= k && k <= s.len() as i32
    }
}