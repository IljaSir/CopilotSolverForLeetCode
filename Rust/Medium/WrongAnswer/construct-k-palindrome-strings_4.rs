impl Solution {
    pub fn can_construct(s: String, k: i32) -> bool {
        
        let mut map = [0; 26];
        for c in s.chars() {
            map[(c as u8 - 'a' as u8) as usize] += 1;
        }
        let mut odd = 0;
        for &v in map.iter() {
            if v % 2 == 1 {
                odd += 1;
            }
        }
        odd <= k
    }
}