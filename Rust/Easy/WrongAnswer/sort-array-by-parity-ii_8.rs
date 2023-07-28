impl Solution {
    pub fn sort_array_by_parity_ii(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![0; nums.len()];
        let mut odd = 0;
        let mut even = 1;
        for n in nums {
            if n % 2 == 0 {
                res[even] = n;
                even += 2;
            } else {
                res[odd] = n;
                odd += 2;
            }
        }
        res
    }
}