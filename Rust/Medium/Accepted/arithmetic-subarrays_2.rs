impl Solution {
    pub fn check_arithmetic_subarrays(nums: Vec<i32>, l: Vec<i32>, r: Vec<i32>) -> Vec<bool> {
        
        let mut ret = Vec::new();
        for i in 0..l.len() {
            let mut tmp = nums[l[i] as usize..=r[i] as usize].to_vec();
            tmp.sort();
            let mut flag = true;
            for j in 1..tmp.len() {
                if tmp[j] - tmp[j-1] != tmp[1] - tmp[0] {
                    flag = false;
                    break;
                }
            }
            ret.push(flag);
        }
        ret
    }
}