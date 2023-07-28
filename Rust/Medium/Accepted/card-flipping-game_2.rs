impl Solution {
    pub fn flipgame(fronts: Vec<i32>, backs: Vec<i32>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for i in 0..fronts.len() {
            if fronts[i] == backs[i] {
                set.insert(fronts[i]);
            }
        }
        let mut ans = 2001;
        for i in 0..fronts.len() {
            if !set.contains(&fronts[i]) {
                ans = ans.min(fronts[i]);
            }
            if !set.contains(&backs[i]) {
                ans = ans.min(backs[i]);
            }
        }
        if ans == 2001 {
            0
        } else {
            ans
        }
    }
}