impl Solution {
    pub fn check_arithmetic_subarrays(nums: Vec<i32>, l: Vec<i32>, r: Vec<i32>) -> Vec<bool> {
        
        let mut result = Vec::new();
        let mut temp = Vec::new();
        for i in 0..l.len() {
            temp = nums[l[i] as usize..=r[i] as usize].to_vec();
            temp.sort();
            let mut flag = true;
            for j in 2..temp.len() {
                if temp[j] - temp[j-1] != temp[1] - temp[0] {
                    flag = false;
                    break;
                }
            }
            result.push(flag);
        }
        result
    }
}