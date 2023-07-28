impl Solution {
    pub fn check_distances(s: String, distance: Vec<i32>) -> bool {
        
        let mut last_index = vec![-1; 26];
        for (i, c) in s.chars().enumerate() {
            let idx = c as usize - 'a' as usize;
            if last_index[idx] != -1 && i as i32 - last_index[idx] - 1 != distance[idx] {
                return false;
            }
            last_index[idx] = i as i32;
        }
        true
    }
}