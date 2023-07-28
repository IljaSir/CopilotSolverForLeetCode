impl Solution {
    pub fn num_of_burgers(tomato_slices: i32, cheese_slices: i32) -> Vec<i32> {
        
        let mut result = vec![];
        for jumbo in 0..=cheese_slices {
            let small = cheese_slices - jumbo;
            if jumbo * 4 + small * 2 == tomato_slices {
                result.push(jumbo);
                result.push(small);
                return result;
            }
        }
        return result;
    }
}