impl Solution {
    pub fn construct_rectangle(area: i32) -> Vec<i32> {
        
        let mut l = (area as f64).sqrt() as i32;
        let mut w = 1;
        while l * w != area {
            if l * w < area {
                w += 1;
            } else {
                l -= 1;
            }
        }
        vec![l, w]
    }
}