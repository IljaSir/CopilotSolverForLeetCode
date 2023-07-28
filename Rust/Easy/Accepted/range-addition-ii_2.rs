impl Solution {
    pub fn max_count(m: i32, n: i32, ops: Vec<Vec<i32>>) -> i32 {
        
        let mut minx = m;
        let mut miny = n;
        for op in ops {
            minx = minx.min(op[0]);
            miny = miny.min(op[1]);
        }
        minx * miny
    }
}