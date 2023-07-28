impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let len = citations.len();
        let mut low = 0;
        let mut high = len;
        while low < high {
            let mid = low + (high - low) / 2;
            if citations[mid] < (len - mid) as i32 {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        (len - low) as i32
    }
}