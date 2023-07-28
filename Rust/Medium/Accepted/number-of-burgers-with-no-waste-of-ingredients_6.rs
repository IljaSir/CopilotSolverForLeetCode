impl Solution {
    pub fn num_of_burgers(tomato_slices: i32, cheese_slices: i32) -> Vec<i32> {
        
        let mut res = vec![];
        let x = (tomato_slices - 2 * cheese_slices) as f32 / 2.0;
        let y = cheese_slices as f32 - x;
        if x >= 0.0 && x.fract() == 0.0 && y >= 0.0 && y.fract() == 0.0 {
            res.push(x as i32);
            res.push(y as i32);
        }
        res
    }
}