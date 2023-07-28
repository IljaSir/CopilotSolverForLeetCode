impl Solution {
    pub fn flipgame(fronts: Vec<i32>, backs: Vec<i32>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for i in 0..fronts.len() {
            if fronts[i] == backs[i] {
                set.insert(fronts[i]);
            }
        }
        let mut res = 2000;
        for i in 0..fronts.len() {
            if !set.contains(&fronts[i]) {
                res = std::cmp::min(res, fronts[i]);
            }
            if !set.contains(&backs[i]) {
                res = std::cmp::min(res, backs[i]);
            }
        }
        if res == 2000 {
            0
        } else {
            res
        }
    }
}