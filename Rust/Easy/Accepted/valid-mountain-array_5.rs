impl Solution {
    pub fn valid_mountain_array(arr: Vec<i32>) -> bool {
        
        let n = arr.len();
        if n < 3 {
            return false;
        }
        let mut i = 0;
        while i < n-1 && arr[i] < arr[i+1] {
            i += 1;
        }
        if i == 0 || i == n-1 {
            return false;
        }
        while i < n-1 && arr[i] > arr[i+1] {
            i += 1;
        }
        i == n-1
    }
}