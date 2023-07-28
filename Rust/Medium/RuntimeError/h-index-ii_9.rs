impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let mut l = 0;
        let mut r = citations.len() - 1;
        let mut mid = 0;
        while l <= r {
            mid = (l + r) / 2;
            if citations[mid] < (citations.len() - mid) as i32 {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        (citations.len() - l) as i32
    }
}