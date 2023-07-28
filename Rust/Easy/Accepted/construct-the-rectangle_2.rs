impl Solution {
    pub fn construct_rectangle(area: i32) -> Vec<i32> {
        
        let mut l = (area as f64).sqrt() as i32;
        while area % l != 0 {
            l -= 1;
        }
        vec![area / l, l]
    }
}