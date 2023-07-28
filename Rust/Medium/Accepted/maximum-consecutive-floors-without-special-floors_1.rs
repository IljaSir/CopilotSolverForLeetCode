impl Solution {
    pub fn max_consecutive(bottom: i32, top: i32, special: Vec<i32>) -> i32 {
        
        let mut special = special;
        special.push(top + 1);
        special.push(bottom - 1);
        special.sort();
        let mut max = 0;
        for i in 0..special.len() - 1 {
            max = max.max(special[i + 1] - special[i] - 1);
        }
        max
    }
}