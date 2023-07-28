impl Solution {
    pub fn max_count(m: i32, n: i32, ops: Vec<Vec<i32>>) -> i32 {
        
        let mut min_a = m;
        let mut min_b = n;
        for op in ops {
            min_a = i32::min(min_a, op[0]);
            min_b = i32::min(min_b, op[1]);
        }
        min_a * min_b
    }
}