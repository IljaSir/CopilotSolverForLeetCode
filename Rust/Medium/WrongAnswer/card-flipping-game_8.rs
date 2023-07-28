impl Solution {
    pub fn flipgame(fronts: Vec<i32>, backs: Vec<i32>) -> i32 {
        
        let mut set: std::collections::HashSet<i32> = fronts.iter().cloned().collect();
        for v in backs.iter() {
            if set.contains(v) {
                set.remove(v);
            }
        }
        if set.is_empty() {
            return 0;
        }
        *set.iter().min().unwrap()
    }
}