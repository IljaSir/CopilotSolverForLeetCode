impl Solution {
    pub fn longest_mountain(arr: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut i = 1;
        while i < arr.len() - 1 {
            if arr[i] > arr[i - 1] && arr[i] > arr[i + 1] {
                let mut left = i - 1;
                let mut right = i + 1;
                while left > 0 && arr[left] > arr[left - 1] {
                    left -= 1;
                }
                while right < arr.len() - 1 && arr[right] > arr[right + 1] {
                    right += 1;
                }
                max = std::cmp::max(max, right - left + 1);
                i = right + 1;
            } else {
                i += 1;
            }
        }
        max as i32
    }
}