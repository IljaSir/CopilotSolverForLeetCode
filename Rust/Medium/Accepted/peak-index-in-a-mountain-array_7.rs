impl Solution {
    pub fn peak_index_in_mountain_array(arr: Vec<i32>) -> i32 {
        
        let mut left = 0;
        let mut right = arr.len() - 1;
        let mut mid = 0;
        while left < right {
            mid = (left + right) / 2;
            if arr[mid] > arr[mid + 1] {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left as i32;
    }
}