impl Solution {
    pub fn num_moves_stones(a: i32, b: i32, c: i32) -> Vec<i32> {
        
        let mut v = vec![a, b, c];
        v.sort();
        let (a, b, c) = (v[0], v[1], v[2]);
        let mut min = 0;
        if b - a == 2 || c - b == 2 {
            min = 1;
        } else if b - a > 2 {
            min += 1;
        }
        if c - b > 2 {
            min += 1;
        }
        let max = c - a - 2;
        vec![min, max]
    }
}