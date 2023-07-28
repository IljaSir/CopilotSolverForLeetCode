impl Solution {
    pub fn find_length_of_shortest_subarray(arr: Vec<i32>) -> i32 {
        
        let len = arr.len();
        let mut left = 0;
        let mut right = len - 1;
        while left < len - 1 && arr[left] <= arr[left + 1] {
            left += 1;
        }
        if left == len - 1 {
            return 0;
        }
        while right > 0 && arr[right] >= arr[right - 1] {
            right -= 1;
        }
        let mut res = std::cmp::min(len - left - 1, right) as i32;
        let mut i = 0;
        let mut j = right;
        while i <= left && j < len {
            if arr[i] <= arr[j] {
                res = std::cmp::min(res, j - i - 1) as i32;
                i += 1;
            } else {
                j += 1;
            }
        }
        res
    }
}