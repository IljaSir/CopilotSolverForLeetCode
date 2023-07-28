impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let mut left = 0;
        let mut right = citations.len() - 1;
        let mut h = 0;
        while left <= right {
            let mid = left + (right - left) / 2;
            let n = citations.len() - mid;
            if citations[mid] >= n as i32 {
                h = n as i32;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        h
    }
}