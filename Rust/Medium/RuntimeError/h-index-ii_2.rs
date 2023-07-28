impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let n = citations.len();
        let mut left = 0;
        let mut right = n - 1;
        while left <= right {
            let mid = (left + right) / 2;
            if citations[mid] as usize == n - mid {
                return citations[mid];
            } else if citations[mid] as usize > n - mid {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        (n - left) as i32
    }
}