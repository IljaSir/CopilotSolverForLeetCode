impl Solution {
    pub fn check_arithmetic_subarrays(nums: Vec<i32>, l: Vec<i32>, r: Vec<i32>) -> Vec<bool> {
        
        let mut res = vec![];
        for i in 0..l.len() {
            let mut tmp = nums[l[i] as usize..=r[i] as usize].to_vec();
            tmp.sort();
            let mut flag = true;
            let mut diff = tmp[1] - tmp[0];
            for j in 2..tmp.len() {
                if tmp[j] - tmp[j-1] != diff {
                    flag = false;
                    break;
                }
            }
            res.push(flag);
        }
        res
    }
}