impl Solution {
    pub fn flipgame(fronts: Vec<i32>, backs: Vec<i32>) -> i32 {
        
        let mut min = 2001;
        let mut f: Vec<i32> = Vec::new();
        let mut b: Vec<i32> = Vec::new();
        for i in 0..fronts.len() {
            if fronts[i] == backs[i] {
                f.push(fronts[i]);
                b.push(backs[i]);
            }
        }
        for i in 0..fronts.len() {
            if !f.contains(&fronts[i]) && fronts[i] < min {
                min = fronts[i];
            }
            if !b.contains(&backs[i]) && backs[i] < min {
                min = backs[i];
            }
        }
        if min == 2001 {
            return 0;
        }
        min
    }
}