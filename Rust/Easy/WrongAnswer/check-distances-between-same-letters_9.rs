impl Solution {
    pub fn check_distances(s: String, distance: Vec<i32>) -> bool {
        
        let mut prev = 0;
        let mut cur = 0;
        let mut char_set = vec![false; 26];
        for ch in s.chars() {
            let index = (ch as u8 - b'a') as usize;
            if char_set[index] {
                cur = index;
                if distance[cur] < (index - prev) as i32 {
                    return false;
                }
                prev = index;
            }
            char_set[index] = true;
        }
        true
    }
}