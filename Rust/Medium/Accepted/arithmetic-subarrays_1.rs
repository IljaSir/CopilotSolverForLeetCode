impl Solution {
    pub fn check_arithmetic_subarrays(nums: Vec<i32>, l: Vec<i32>, r: Vec<i32>) -> Vec<bool> {
        
        let mut res = Vec::new();
        for i in 0..l.len() {
            let mut sub = nums[l[i] as usize..=r[i] as usize].to_vec();
            sub.sort();
            let mut is_arithmetic = true;
            for j in 1..sub.len() {
                if sub[j] - sub[j - 1] != sub[1] - sub[0] {
                    is_arithmetic = false;
                    break;
                }
            }
            res.push(is_arithmetic);
        }
        res
    }
}