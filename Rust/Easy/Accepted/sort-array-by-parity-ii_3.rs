impl Solution {
    pub fn sort_array_by_parity_ii(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![0; nums.len()];
        let mut i = 0;
        let mut j = 1;
        for n in nums {
            if n % 2 == 0 {
                res[i] = n;
                i += 2;
            } else {
                res[j] = n;
                j += 2;
            }
        }
        res
    }
}