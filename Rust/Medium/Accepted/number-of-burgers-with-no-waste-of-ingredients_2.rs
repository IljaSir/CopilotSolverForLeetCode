impl Solution {
    pub fn num_of_burgers(tomato_slices: i32, cheese_slices: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        let jumbo = (tomato_slices - 2 * cheese_slices) / 2;
        let small = cheese_slices - jumbo;
        if jumbo < 0 || small < 0 || jumbo * 4 + small * 2 != tomato_slices {
            return res;
        }
        res.push(jumbo);
        res.push(small);
        res
    }
}