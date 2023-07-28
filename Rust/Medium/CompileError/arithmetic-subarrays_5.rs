impl Solution {
    pub fn check_arithmetic_subarrays(nums: Vec<i32>, l: Vec<i32>, r: Vec<i32>) -> Vec<bool> {
        
        let mut result = Vec::new();
        for i in 0..l.len() {
            let mut subarray = &nums[l[i] as usize..=r[i] as usize];
            subarray.sort();
            let mut is_arithmetic = true;
            for j in 1..subarray.len() {
                if subarray[j] - subarray[j-1] != subarray[1] - subarray[0] {
                    is_arithmetic = false;
                    break;
                }
            }
            result.push(is_arithmetic);
        }
        result
    }
}