impl Solution {
    pub fn check_arithmetic_subarrays(nums: Vec<i32>, l: Vec<i32>, r: Vec<i32>) -> Vec<bool> {
        
        let mut ans = Vec::new();
        for i in 0..l.len() {
            let mut temp = nums[l[i] as usize..=r[i] as usize].to_vec();
            temp.sort();
            let mut j = 1;
            let mut flag = true;
            let diff = temp[1] - temp[0];
            while j < temp.len() - 1 {
                if temp[j + 1] - temp[j] != diff {
                    flag = false;
                    break;
                }
                j += 1;
            }
            ans.push(flag);
        }
        ans
    }
}