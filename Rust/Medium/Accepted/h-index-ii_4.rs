impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let n = citations.len();
        let mut l = 0;
        let mut r = n;
        while l < r {
            let mid = l + (r - l) / 2;
            if citations[mid] >= (n - mid) as i32 {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        (n - l) as i32
    }
}