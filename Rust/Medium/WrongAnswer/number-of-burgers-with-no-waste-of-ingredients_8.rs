impl Solution {
    pub fn num_of_burgers(tomato_slices: i32, cheese_slices: i32) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let mut total_jumbo = 0;
        let mut total_small = 0;
        if tomato_slices % 2 == 0 {
            total_jumbo = tomato_slices / 2 - cheese_slices;
            total_small = cheese_slices - total_jumbo;
        }
        if total_jumbo >= 0 && total_small >= 0 {
            ans.push(total_jumbo);
            ans.push(total_small);
        }
        ans
    }
}