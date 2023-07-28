impl Solution {
    pub fn find_length_of_shortest_subarray(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut l = 0;
        while l + 1 < n && arr[l] <= arr[l + 1] {
            l += 1;
        }
        if l == n - 1 {
            return 0;
        }
        let mut r = n - 1;
        while r > 0 && arr[r - 1] <= arr[r] {
            r -= 1;
        }
        let mut res = (r - l - 1) as i32;
        let mut i = 0;
        let mut j = r;
        while i <= l && j < n {
            if arr[i] <= arr[j] {
                res = res.min((j - i - 1) as i32);
                i += 1;
            } else {
                j += 1;
            }
        }
        res
    }
}