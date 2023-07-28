impl Solution {
    pub fn check_distances(s: String, distance: Vec<i32>) -> bool {
        
        let mut pos = vec![0; 26];
        let mut diff = vec![0; 26];
        let mut last = 0;
        for (i, c) in s.chars().enumerate() {
            let idx = (c as u8 - 'a' as u8) as usize;
            diff[idx] = i - pos[idx];
            pos[idx] = i;
            last = i;
        }
        for i in 0..26 {
            diff[i] = last - pos[i] + diff[i];
        }
        for i in 0..26 {
            if distance[i] != 0 && distance[i] != diff[i] {
                return false;
            }
        }
        true
    }
}