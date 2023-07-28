impl Solution {
    pub fn get_last_moment(n: i32, left: Vec<i32>, right: Vec<i32>) -> i32 {
        
        let mut left = left;
        let mut right = right;
        left.sort();
        right.sort();
        let mut l = 0;
        let mut r = 0;
        for i in 0..left.len() {
            l = l.max(left[i]);
        }
        for i in 0..right.len() {
            r = r.max(n - right[i]);
        }
        l.max(r)
    }
}