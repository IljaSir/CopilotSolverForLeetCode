impl Solution {
    pub fn flipgame(fronts: Vec<i32>, backs: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..fronts.len() {
            if fronts[i] == backs[i] {
                map.insert(fronts[i], 1);
            }
        }
        for i in 0..fronts.len() {
            if map.contains_key(&fronts[i]) {
                continue;
            }
            if res == 0 || fronts[i] < res {
                res = fronts[i];
            }
        }
        for i in 0..backs.len() {
            if map.contains_key(&backs[i]) {
                continue;
            }
            if res == 0 || backs[i] < res {
                res = backs[i];
            }
        }
        res
    }
}