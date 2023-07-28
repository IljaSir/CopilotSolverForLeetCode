impl Solution {
    pub fn check_arithmetic_subarrays(nums: Vec<i32>, l: Vec<i32>, r: Vec<i32>) -> Vec<bool> {
        
        let mut res = vec![];
        for i in 0..l.len() {
            let mut slice = nums[l[i] as usize..=r[i] as usize].to_vec();
            slice.sort();
            let mut diff = slice[1] - slice[0];
            let mut flag = true;
            for j in 2..slice.len() {
                if slice[j] - slice[j-1] != diff {
                    flag = false;
                    break;
                }
            }
            res.push(flag);
        }
        res
    }
}