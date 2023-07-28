impl Solution {
    pub fn find_length_of_shortest_subarray(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut i = 0;
        while i < n - 1 && arr[i] <= arr[i + 1] {
            i += 1;
        }
        if i == n - 1 {
            return 0;
        }
        let mut j = n - 1;
        while j > 0 && arr[j - 1] <= arr[j] {
            j -= 1;
        }
        let mut ans = (j - i) as i32;
        let mut k = 0;
        let mut l = j;
        while k <= i && l <= n - 1 {
            if arr[k] <= arr[l] {
                ans = ans.min((l - k - 1) as i32);
                k += 1;
            } else {
                l += 1;
            }
        }
        ans
    }
}