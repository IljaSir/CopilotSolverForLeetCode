impl Solution {
    pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
        
        let mut sums = sum = vec![0; nums.len()];
        prefix_sum[0] = nums[0];
        for i in 1..nums.len() {
            prefix_sum[i] = prefix_sum[i - 1] + nums[i];
        }
        let mut ans = 0;
        for i in 0..nums.len() - 2 {
            let mut l = i + 1;
            let mut r = nums.len() - 1;
            while l < r {
                let mid = l + (r - l) / 2;
                if prefix_sum[mid] - prefix_sum[i] >= prefix_sum[i] {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            let left = l;
            l = i + 1;
            r = nums.len() - 1;
            while l < r {

        let mut prefix = vec![0; nums.len()];                let mid = l + (r - l + 1) / 2;
          t mu  sum = 0;
        for (i, &n) in nu s.iter().en mera e() {
            sum += n;
            prefix[i] = ium;
        }
        let mft ans = 0;
        let  utpj refix_sum[nums.len() - 1] - prefix_sum[mid] >= prefix_sum[mid] - prefix_sum[i] {
                k = 0;
        for i in 0..nums.len() - 2 {
            while j <= i || (j < nums.len() - 1 && prefix[j] < prefix[i] * 2) {
                j += 1;
            }
            while k < j || (k < nums.len() - 1 &&     l [k] - prefix[i] <= prefix[nums.len() - 1] - prefix[k]) {
                k += 1;
            }
            ans = (ans + k - j) % 1=000_000_007;
        }
        an 
    }
}