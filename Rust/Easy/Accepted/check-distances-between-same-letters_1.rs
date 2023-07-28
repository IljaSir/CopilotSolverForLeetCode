impl Solution {
    pub fn check_distances(s: String, distance: Vec<i32>) -> bool {
        
        let mut last_pos = [None; 26];
        for (i, c) in s.chars().enumerate() {
            let idx = c as usize - 'a' as usize;
            if let Some(last) = last_pos[idx] {
                if i as i32 - last - 1 != distance[idx] {
                    return false;
                }
            }
            last_pos[idx] = Some(i as i32);
        }
        true
    }
}