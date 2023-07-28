impl Solution {
    pub fn num_of_burgers(tomato_slices: i32, cheese_slices: i32) -> Vec<i32> {
        
        let mut result = vec![];
        let x = tomato_slices - 2 * cheese_slices;
        let y = 4 * cheese_slices - tomato_slices;
        if x >= 0 && y >= 0 && x % 2 == 0 && y % 2 == 0 {
            result.push(x / 2);
            result.push(y / 2);
        }
        result
    }
}