impl Solution {
    pub fn num_of_burgers(tomato_slices: i32, cheese_slices: i32) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let a = (tomato_slices - 2 * cheese_slices) as f32 / 2.0;
        let b = (4 * cheese_slices - tomato_slices) as f32 / 2.0;
        if a >= 0.0 && b >= 0.0 && (a - a.floor()).abs() < 0.000001 && (b - b.floor()).abs() < 0.000001 {
            ans.push(a as i32);
            ans.push(b as i32);
        }
        ans
    }
}