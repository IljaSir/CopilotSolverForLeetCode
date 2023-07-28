impl Solution {
    pub fn longest_mountain(arr: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let (mut left, mut right) = (0, 0);
        while right < arr.len() {
            while left < arr.len() && left + 1 < arr.len() && arr[left] >= arr[left + 1] {
                left += 1;
            }
            right = left;
            while right < arr.len() && right + 1 < arr.len() && arr[right] < arr[right + 1] {
                right += 1;
            }
            while right < arr.len() && right + 1 < arr.len() && arr[right] > arr[right + 1] {
                right += 1;
            }
            res = res.max(right - left + 1);
            left = right;
        }
        if res < 3 { 0 } else { res as i32 }
    }
}