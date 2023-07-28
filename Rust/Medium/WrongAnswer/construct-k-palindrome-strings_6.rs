impl Solution {
    pub fn can_construct(s: String, k: i32) -> bool {
        
        let mut char_count = vec![0; 26];
        for c in s.chars() {
            char_count[c as usize - 'a' as usize] += 1;
        }
        let mut odd_count = 0;
        for i in 0..26 {
            if char_count[i] % 2 == 1 {
                odd_count += 1;
            }
        }
        odd_count <= k
    }
}