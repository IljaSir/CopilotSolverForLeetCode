impl Solution {
    pub fn check_distances(s: String, distance: Vec<i32>) -> bool {
        
        let mut last = s.chars().nth(0).unwrap() as i32 - 'a' as i32;
        let mut last_index = 0;
        for (i, c) in s.chars().enumerate() {
            let index = c as i32 - 'a' as i32;
            if last == index {
                if i - last_index - 1 < distance[index as usize] {
                    return false;
                }
                last_index = i;
            }
            last = index;
        }
        true
    }
}