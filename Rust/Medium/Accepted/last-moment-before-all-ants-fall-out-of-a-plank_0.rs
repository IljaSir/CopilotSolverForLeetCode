impl Solution {
    pub fn get_last_moment(n: i32, left: Vec<i32>, right: Vec<i32>) -> i32 {
        
        let mut max = 0;
        for i in 0..left.len() {
            if left[i] > max {
                max = left[i];
            }
        }
        for i in 0..right.len() {
            if n - right[i] > max {
                max = n - right[i];
            }
        }
        max
    }
}