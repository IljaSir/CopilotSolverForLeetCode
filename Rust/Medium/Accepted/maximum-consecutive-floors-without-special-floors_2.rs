impl Solution {
    pub fn max_consecutive(bottom: i32, top: i32, special: Vec<i32>) -> i32 {
        
        let mut special = special;
        special.sort();
        let mut max = 0;
        let mut last = bottom - 1;
        for s in special {
            if s - last > 1 {
                max = max.max(s - last - 1);
            }
            last = s;
        }
        max = max.max(top - last);
        max
    }
}