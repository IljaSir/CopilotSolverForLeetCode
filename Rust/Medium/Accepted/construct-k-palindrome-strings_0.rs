impl Solution {
    pub fn can_construct(s: String, k: i32) -> bool {
        
        if s.len() < k as usize {
            return false;
        }
        if s.len() == k as usize {
            return true;
        }
        let mut count = vec![0; 26];
        for c in s.chars() {
            count[(c as u8 - 'a' as u8) as usize] += 1;
        }
        let mut odd = 0;
        for i in 0..26 {
            if count[i] % 2 == 1 {
                odd += 1;
            }
        }
        odd <= k
    }
}