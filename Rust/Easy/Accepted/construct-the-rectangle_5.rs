impl Solution {
    pub fn construct_rectangle(area: i32) -> Vec<i32> {
        
        let mut n = (area as f64).sqrt() as i32;
        while area % n != 0 {
            n -= 1;
        }
        vec![area/n, n]
    }
}