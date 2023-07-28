impl Solution {
    pub fn num_of_burgers(tomato_slices: i32, cheese_slices: i32) -> Vec<i32> {
        
        let x = tomato_slices - 2 * cheese_slices;
        let y = 4 * cheese_slices - tomato_slices;
        if x < 0 || y < 0 || x % 2 != 0 || y % 2 != 0 {
            return vec![];
        }
        let x = x / 2;
        let y = y / 2;
        if x + y != cheese_slices {
            return vec![];
        }
        vec![x, y]
    }
}