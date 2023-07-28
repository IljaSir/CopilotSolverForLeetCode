impl Solution {
    pub fn num_of_burgers(tomato_slices: i32, cheese_slices: i32) -> Vec<i32> {
        
        let mut jumbo = 0;
        let mut small = 0;
        for i in 0..cheese_slices+1 {
            jumbo = i;
            small = cheese_slices - i;
            if jumbo * 4 + small * 2 == tomato_slices {
                return vec![jumbo, small];
            }
        }
        return vec![];
    }
}