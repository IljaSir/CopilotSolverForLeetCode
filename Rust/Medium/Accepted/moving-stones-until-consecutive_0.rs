impl Solution {
    pub fn num_moves_stones(a: i32, b: i32, c: i32) -> Vec<i32> {
        
        let mut v = vec![a, b, c];
        v.sort();
        let min = if v[1] - v[0] == 1 && v[2] - v[1] == 1 {
            0
        } else if v[1] - v[0] <= 2 || v[2] - v[1] <= 2 {
            1
        } else {
            2
        };
        let max = v[2] - v[0] - 2;
        vec![min, max]
    }
}