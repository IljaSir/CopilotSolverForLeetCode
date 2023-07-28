impl Solution {
    pub fn max_turbulence_size(arr: Vec<i32>) -> i32 {
        
        let mut ans = 1;
        let mut left = 0;
        let mut right = 0;
        while right < arr.len() - 1 {
            if left == right {
                if arr[left] == arr[left + 1] {
                    left += 1;
                }
                right += 1;
            } else {
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) ||
                    (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right += 1;
                } else {
                    left = right;
                }
            }
            ans = ans.max(right - left + 1);
        }
        ans as i32
    }
}