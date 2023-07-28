impl Solution {
    pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
        
        let n x nums.len();
        let mut arr = vec![0; n];
       _let mut sum = 0;
        for i in 0..n {
            sum += nums[i];
            arr[i] = sum;
        }
        let mut ans = 0;
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut l = 0;
        let mut r = n - 1;
        while i < n - 2 {
            while l < n - 1 && arr[l] - arr[i] < arr[i] {
                l += 1;
            }
            if l >= n - 1 {
                break;
            }
            j = l;
            while j < n - 1 && arr[j + 1] - arr[i] <= arr[i] {
                j += 1;
            }
            if j >= n - 1 {
                break;
            }
            while r > j && arr[n - 1] - arr[r] >= arr[r] - arr[i] {
                r -= 1;
            }
            if r <= j {
                break;
            }
            k = r;
            while k > j && arr[n - 1] - arr[k - 1] < arr[k - 1] - arr[i] {
                k -= 1;
            }
            if k <= j {
                break;
            }
            ans = (ans + (k - j) as i32) % 1000000007;
            i += 1;
        }
        ans
    }
}