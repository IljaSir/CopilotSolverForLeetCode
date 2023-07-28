impl Solution {
    pub fn max_count(m: i32, n: i32, ops: Vec<Vec<i32>>) -> i32 {
        
        let (mut min_x, mut min_y) = (m, n);
        for op in ops {
            min_x = min_x.min(op[0]);
            min_y = min_y.min(op[1]);
        }
        min_x * min_y
    }
}