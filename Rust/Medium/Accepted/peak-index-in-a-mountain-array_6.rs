impl Solution {
    pub fn peak_index_in_mountain_array(arr: Vec<i32>) -> i32 {
        
        let mut left: i32 = 0;
        let mut right: i32 = arr.len() as i32 - 1;
        while left < right {
            let mid = left + (right - left) / 2;
            if arr[mid as usize] < arr[(mid + 1) as usize] {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left
    }
}