impl Solution {
    pub fn num_of_burgers(tomato_slices: i32, cheese_slices: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut x = 0;
        let mut y = 0;
        if tomato_slices % 2 == 1 {
            return res;
        }
        x = tomato_slices / 2 - cheese_slices;
        y = cheese_slices - x;
        if x >= 0 && y >= 0 && 2 * x + 4 * y == tomato_slices && x + y == cheese_slices {
            res.push(x);
            res.push(y);
        }
        res
    }
}