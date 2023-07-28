impl Solution {
    pub fn can_construct(s: String, k: i32) -> bool {
        
        if k as usize > s.len() {
            return false;
        }
        let mut count = vec![0; 26];
        for ch in s.chars() {
            count[ch as usize - 'a' as usize] += 1;
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