impl Solution {
    pub fn flipgame(fronts: Vec<i32>, backs: Vec<i32>) -> i32 {
        
        let mut f = fronts.clone();
        let mut b = backs.clone();
        let mut ans = 2001;
        for i in 0..fronts.len() {
            if fronts[i] == backs[i] {
                f[i] = 0;
                b[i] = 0;
            }
        }
        for i in 0..fronts.len() {
            if f[i] != 0 {
                ans = ans.min(f[i]);
            }
            if b[i] != 0 {
                ans = ans.min(b[i]);
            }
        }
        if ans == 2001 {
            return 0;
        }
        ans
    }
}