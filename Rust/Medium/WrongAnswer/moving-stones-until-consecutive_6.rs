impl Solution {
    pub fn num_moves_stones(a: i32, b: i32, c: i32) -> Vec<i32> {
        
        let mut v = vec![a, b, c];
        v.sort();
        let a = v[0];
        let b = v[1];
        let c = v[2];
        let mut max = c - a - 2;
        let mut min = 0;
        if b - a == 1 && c - b == 1 {
            max = 0;
        } else if b - a == 1 || c - b == 1 {
            min = 1;
        } else {
            min = 2;
        }
        vec![min, max]
    }
}