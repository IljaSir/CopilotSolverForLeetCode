impl Solution {
    pub fn flipgame(fronts: Vec<i32>, backs: Vec<i32>) -> i32 {
        
        let mut good = std::collections::HashSet::new();
        let n = fronts.len();
        for i in 0..n {
            if fronts[i] == backs[i] {
                good.insert(fronts[i]);
            }
        }
        let mut ans = 0;
        for i in 0..n {
            if !good.contains(&fronts[i]) {
                if ans == 0 {
                    ans = fronts[i];
                } else {
                    ans = ans.min(fronts[i]);
                }
            }
            if !good.contains(&backs[i]) {
                if ans == 0 {
                    ans = backs[i];
                } else {
                    ans = ans.min(backs[i]);
                }
            }
        }
        ans
    }
}