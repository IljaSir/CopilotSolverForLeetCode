impl Solution {
    pub fn num_moves_stones(a: i32, b: i32, c: i32) -> Vec<i32> {
        
        let mut vec = vec![a, b, c];
        vec.sort();
        let a = vec[0];
        let b = vec[1];
        let c = vec[2];
        let mut min = 2;
        if b - a == 1 && c - b == 1 {
            min = 0;
        } else if b - a == 1 || c - b == 1 || b - a == 2 || c - b == 2 {
            min = 1;
        }
        let max = c - a - 2;
        vec![min, max]
    }
}