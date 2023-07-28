impl Solution {
    pub fn flipgame(fronts: Vec<i32>, backs: Vec<i32>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for i in 0..fronts.len() {
            if fronts[i] == backs[i] {
                set.insert(fronts[i]);
            }
        }
        let mut ans = std::i32::MAX;
        for i in 0..fronts.len() {
            if fronts[i] != backs[i] {
                if !set.contains(&fronts[i]) {
                    ans = ans.min(fronts[i]);
                }
                if !set.contains(&backs[i]) {
                    ans = ans.min(backs[i]);
                }
            }
        }
        if ans == std::i32::MAX {
            return 0;
        }
        ans
    }
}