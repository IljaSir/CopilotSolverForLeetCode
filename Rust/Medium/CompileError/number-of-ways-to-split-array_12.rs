impl Solution {
    pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
        
        let mut prefix = vec![0; nums.len()];
        let mut sum = 0;
        for (i, &n) in nums.iter().enumerate() {
            sum += n;
            prefix[i] = sum;
        }
        let mut ans = 0;
        let mut j = 0;
        let mut k = 0;
        for i in 0..nums.len() - 2 {
            while j <= i || (j < nums.len() - 1 && prefix[j] < prefix[i] * 2) {
                j += 1;
            }
            while k < j || (k < nums.len() - 1 && prefix[k] - prefix[i] <= prefix[nums.len() - 1] - prefix[k]) {
                k += 1;
            }
            ans = (ans + k - j) % 1_000_000_007;
        }
        ans
    }
}