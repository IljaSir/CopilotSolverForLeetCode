impl Solution {
    pub fn find_length_of_shortest_subarray(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut i = 0;
        while i + 1 < n && arr[i] <= arr[i + 1] {
            i += 1;
        }
        if i == n - 1 {
            return 0;
        }
        let mut j = n - 1;
        while j > 0 && arr[j - 1] <= arr[j] {
            j -= 1;
        }
        let mut res = std::cmp::min(n - i - 1, j) as i32;
        let mut k = 0;
        while k <= i && j < n {
            if arr[k] <= arr[j] {
                res = std::cmp::min(res, j - k - 1) as i32;
                k += 1;
            } else {
                j += 1;
            }
        }
        res
    }
}